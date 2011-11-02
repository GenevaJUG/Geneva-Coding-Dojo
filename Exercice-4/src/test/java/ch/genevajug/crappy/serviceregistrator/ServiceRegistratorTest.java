package ch.genevajug.crappy.serviceregistrator;

import ch.genevajug.crappy.hello.SimpleConfig;
import ch.genevajug.crappy.serviceregistor.impl.IdGenerator;
import ch.genevajug.crappy.serviceregistor.impl.ServiceRegistrator;
import ch.genevajug.crappy.serviceregistor.osgi.BundleContext;
import ch.genevajug.crappy.serviceregistor.osgi.ServiceRegistration;
import org.fest.assertions.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import java.util.HashMap;
import java.util.Map;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;
import static org.powermock.reflect.Whitebox.getInternalState;
import static org.powermock.reflect.Whitebox.setInternalState;

/**
 * Created by IntelliJ IDEA.
 * User: codingdojo
 * Date: 11/2/11
 * Time: 12:26 PM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(IdGenerator.class)
public class ServiceRegistratorTest {

    @Mock
    BundleContext bundleContext;

    @InjectMocks
    ServiceRegistrator serviceRegistrator = new ServiceRegistrator();

    @Test
    public void shouldAddServiceRegistrationToTheMap() {
        Object serviceImplementation = mock(Object.class);
        ServiceRegistration serviceRegistration = mock(ServiceRegistration.class);
        PowerMockito.mockStatic(IdGenerator.class);

        when(bundleContext.registerService(eq("Test"), eq(serviceImplementation), anyString())).thenReturn(serviceRegistration);
        when(IdGenerator.generateNewId()).thenReturn(100L);

        long id = serviceRegistrator.registerService("Test", serviceImplementation);

        Map serviceRegistrationsMap = getInternalState(serviceRegistrator, Map.class);

        assertThat(id).isEqualTo(100L);
        assertThat(serviceRegistrationsMap).hasSize(1);
        assertThat(serviceRegistrationsMap.get(100L)).isEqualTo(serviceRegistration);
    }

    @Test
    public void mapShouldBeEmptyAfterUnregistration() {
        ServiceRegistration serviceRegistration = mock(ServiceRegistration.class);
        Map<Long, ServiceRegistration> serviceRegistrationsMap = new HashMap<Long, ServiceRegistration>();
        serviceRegistrationsMap.put(100L, serviceRegistration);

        setInternalState(serviceRegistrator, serviceRegistrationsMap);

        serviceRegistrator.unregisterService(100L);

        assertThat(serviceRegistrationsMap).isEmpty();
        verify(serviceRegistration, times(1)).unregister();
    }


    @Test(expected = IllegalStateException.class)
    public void shouldThrowIllegalExceptionWhenIdNotFound() {
        Map serviceRegistrationsMap = mock(Map.class);
        when(serviceRegistrationsMap.get(100L)).thenReturn(null);

        setInternalState(serviceRegistrator, serviceRegistrationsMap);

        serviceRegistrator.unregisterService(100L);
    }
}
