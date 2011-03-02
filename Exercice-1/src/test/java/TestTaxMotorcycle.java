import org.fest.assertions.Assertions;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;

public class TestTaxMotorcycle {

    TaxMotorcycleCalculator taxCalculator = new TaxMotorcycleCalculator();

    @Test
    public void engineSizeLessOrEqualsTo150ShouldReturn15() {
        Motorcycle motorcycle = createMotorcycle(120);

        BigDecimal tax =  taxCalculator.calculate(motorcycle);

        Assertions.assertThat(tax).isEqualTo(new BigDecimal("15"));
    }

    @Test
    public void engineSizeBetween151And400ShouldReturn30() {
        Motorcycle motorcycle = createMotorcycle(300);

        BigDecimal tax =  taxCalculator.calculate(motorcycle);

        Assertions.assertThat(tax).isEqualTo(new BigDecimal("30"));
    }

    @Test
    public void engineSizeBetween401And600ShouldReturn45() {
        Motorcycle motorcycle = createMotorcycle(500);

        BigDecimal tax =  taxCalculator.calculate(motorcycle);

        Assertions.assertThat(tax).isEqualTo(new BigDecimal("45"));
    }

    @Test
    public void engineSizeMoreThan600ShouldReturn60() {
        Motorcycle motorcycle = createMotorcycle(700);

        BigDecimal tax =  taxCalculator.calculate(motorcycle);

        Assertions.assertThat(tax).isEqualTo(new BigDecimal("60"));
    }

    private Motorcycle createMotorcycle(int engineSize) {
        Motorcycle motorcycle = mock(Motorcycle.class);
        Mockito.when(motorcycle.getEngineSize()).thenReturn(engineSize);
        return motorcycle;
    }
}
