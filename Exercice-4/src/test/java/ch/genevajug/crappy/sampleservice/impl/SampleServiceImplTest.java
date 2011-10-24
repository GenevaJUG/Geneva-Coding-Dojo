package ch.genevajug.crappy.sampleservice.impl;

import ch.genevajug.crappy.sampleservice.EventService;
import ch.genevajug.crappy.sampleservice.PersonService;
import ch.genevajug.crappy.sampleservice.domain.BusinessMessages;
import ch.genevajug.crappy.sampleservice.domain.Person;
import ch.genevajug.crappy.sampleservice.domain.SampleServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.fest.assertions.Assertions.assertThat;
import static org.fest.assertions.Fail.fail;
import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.whenNew;

/**
 * Created by IntelliJ IDEA.
 * User: codingdojo
 * Date: 10/19/11
 * Time: 12:39 PM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(SampleServiceImpl.class)
public class SampleServiceImplTest {

    @Test
    public void shouldReturnTrueWhenCreatePersonIsOk() throws Exception {
        PersonService personService = mock(PersonService.class);
        EventService eventService = mock(EventService.class);
        BusinessMessages businessMessages = mock(BusinessMessages.class);

        whenNew(BusinessMessages.class).withNoArguments().thenReturn(businessMessages);
        when(businessMessages.hasErrors()).thenReturn(false);

        SampleServiceImpl sampleService = new SampleServiceImpl(personService, eventService);

        boolean isCreated = sampleService.createPerson("Maxime", "Nowak");

        assertThat(isCreated).isTrue();
        verify(personService, times(1)).create(any(Person.class), any(BusinessMessages.class));
        verifyZeroInteractions(eventService);
    }

    @Test
    public void shouldReturnTrueWhenCreatePersonIsNonOk() throws Exception {
        PersonService personService = mock(PersonService.class);
        EventService eventService = mock(EventService.class);
        BusinessMessages businessMessages = mock(BusinessMessages.class);

        whenNew(BusinessMessages.class).withNoArguments().thenReturn(businessMessages);
        when(businessMessages.hasErrors()).thenReturn(true);
        InOrder inOrder = inOrder(personService, eventService);

        SampleServiceImpl sampleService = new SampleServiceImpl(personService, eventService);

        boolean isCreated = sampleService.createPerson("Maxime", "Nowak");

        assertThat(isCreated).isFalse();

        inOrder.verify(personService, times(1)).create(any(Person.class), any(BusinessMessages.class));
        inOrder.verify(eventService, times(1)).sendErrorEvent(any(Person.class), eq(businessMessages));
    }

    @Test
    public void shouldThrowSampleServiceExceptionWhenPersonInstantiationFailed() throws Exception {
        PersonService personService = mock(PersonService.class);
        EventService eventService = mock(EventService.class);
        BusinessMessages businessMessages = mock(BusinessMessages.class);
        IllegalArgumentException illegalArgumentException = mock(IllegalArgumentException.class);

        whenNew(BusinessMessages.class).withNoArguments().thenReturn(businessMessages);
        whenNew(Person.class).withArguments("Maxime", "Nowak").thenThrow(illegalArgumentException);
        when(illegalArgumentException.getMessage()).thenReturn("Test");

        SampleServiceImpl sampleService = new SampleServiceImpl(personService, eventService);

        try {
            boolean isCreated = sampleService.createPerson("Maxime", "Nowak");
            fail("Should not happen !");
        } catch (SampleServiceException sampleServiceException) {
            assertThat(sampleServiceException.getMessage()).isEqualTo("Test");
            verifyZeroInteractions(personService);
            verifyZeroInteractions(eventService);
        }

    }
}
