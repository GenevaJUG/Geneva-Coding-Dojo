import org.junit.Test;
import org.mockito.Mockito;

import static org.fest.assertions.Assertions.*;
import static org.mockito.Mockito.*;

public class TestCalculatorFactory {

    TaxCalculatorFactory factory = new TaxCalculatorFactory();

    @Test
    public void shouldReturnATaxCarCalculatorWhenUsingCarAsVehicle() {

        Car car = mock(Car.class, CALLS_REAL_METHODS);

        TaxCalculator calculator = factory.getCalculator(car);

        assertThat(calculator).isInstanceOf(TaxCarCalculator.class);

    }

    @Test
    public void shouldReturnATaxVanCalculatorWhenUsingVanAsVehicle() {

        Van van = mock(Van.class, CALLS_REAL_METHODS);

        TaxCalculator calculator = factory.getCalculator(van);

        assertThat(calculator).isInstanceOf(TaxVanCalculator.class);

    }

    @Test
    public void shouldReturnATaxMotorcycleCalculatorWhenUsingMotorcycleAsVehicle() {

        Motorcycle motorcycle = mock(Motorcycle.class, CALLS_REAL_METHODS);

        TaxCalculator calculator = factory.getCalculator(motorcycle);

        assertThat(calculator).isInstanceOf(TaxMotorcycleCalculator.class);
    }

}
