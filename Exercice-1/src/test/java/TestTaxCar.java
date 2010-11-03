import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by IntelliJ IDEA.
 * User: maximenowak
 * Date: 20 oct. 2010
 * Time: 13:05:14
 * To change this template use File | Settings | File Templates.
 */
public class TestTaxCar {

    private TaxCalculator taxCalculator = new TaxCalculator();

    @Test
    public void testEngineSizeLessThan1550ccAndRegistrionDateBefore200131() {

        Car car = new Car();

        car.setEngineSize(1500);
        car.setRegistrationDate(new Date(2000,3,1));

        assertTrue(BigDecimal.valueOf(110L).equals(taxCalculator.calculate(car)));
    }

    @Test
    public void testEngineSizeLessThan1550ccAndRegistrionDateAfter200131() {

        Car car = new Car();

        car.setEngineSize(1500);
        car.setRegistrationDate(new Date(2002,3,1));

        Assert.assertFalse(BigDecimal.valueOf(110L).equals(taxCalculator.calculate(car)));
    }

    @Test
    public void testEngineSizeEquals1550cc() {

        Car car = new Car();

        car.setEngineSize(1550);

        assertEquals(BigDecimal.valueOf(110L), taxCalculator.calculate(car));
    }
    @Test
    public void testEngineSizeGreaterThan1550cc() {

        Car car = new Car();

        car.setEngineSize(2000);

        assertEquals(BigDecimal.valueOf(165L), taxCalculator.calculate(car));
    }


}
