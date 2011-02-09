import org.junit.Test;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.math.BigDecimal;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@RunWith(Theories.class)
public class TestTaxCarAfterMarch2001 {

    private static TaxCalculator taxCalculator = new TaxCalculator();

    @DataPoint
    public static DataTestCO2 upTo100 = new DataTestCO2(carWithCo2(85), "65");

    @DataPoint
    public static DataTestCO2 equalsTo100 = new DataTestCO2(carWithCo2(100), "65");

    @DataPoint
    public static DataTestCO2 equalsTo101 = new DataTestCO2(carWithCo2(101), "75");

    @DataPoint
    public static DataTestCO2 between101And120 = new DataTestCO2(carWithCo2(110), "75");

    @DataPoint
    public static DataTestCO2 between121And150 = new DataTestCO2(carWithCo2(130), "105");

    @DataPoint
    public static DataTestCO2 between151And165 = new DataTestCO2(carWithCo2(165), "125");

    @DataPoint
    public static DataTestCO2 between166And185 = new DataTestCO2(carWithCo2(180), "145");

    @DataPoint
    public static DataTestCO2 over185 = new DataTestCO2(carWithCo2(190), "160");


    @Theory
    public void testEngineWithCO2(DataTestCO2 dataTestCO2) {
        BigDecimal tax = taxCalculator.calculate(dataTestCO2.getCar());

        assertThat(tax).isEqualTo(dataTestCO2.getExpectedTax());
    }


    private static Car carWithCo2(int co2) {
        Car car = mock(Car.class);
        when(car.getCO2()).thenReturn(co2);
        when(car.isRegisteredAfter(TaxCalculator.CO2_TAX_DATE)).thenReturn(true);
        return car;
    }

    private static class DataTestCO2 {
        private Car car;
        private BigDecimal expectedTax;

        private DataTestCO2(Car car, String expectedTax) {
            this.car = car;
            this.expectedTax = new BigDecimal(expectedTax);
        }

        public Car getCar() {
            return car;
        }

        public BigDecimal getExpectedTax() {
            return expectedTax;
        }
    }
}
