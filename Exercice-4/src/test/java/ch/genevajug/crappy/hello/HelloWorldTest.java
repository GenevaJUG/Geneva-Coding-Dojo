package ch.genevajug.crappy.hello;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

/**
 * Created by IntelliJ IDEA.
 * User: codingdojo
 * Date: 10/19/11
 * Time: 12:24 PM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(SimpleConfig.class)
public class HelloWorldTest {

    @Before
    public void setUp() {
        mockStatic(SimpleConfig.class);
    }

    @Test
    public void shouldReturnHelloWorldWhenCallingGreet() {
        when(SimpleConfig.getGreeting()).thenReturn("Hello");
        when(SimpleConfig.getTarget()).thenReturn("World");

        HelloWorld helloWorld = new HelloWorld();

        assertThat(helloWorld.greet()).isEqualTo("Hello World");
    }
}

