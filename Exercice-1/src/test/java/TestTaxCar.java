import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class TestTaxCar {

    private static final Date PREMIER_MARS_2000 =  new Date(100,3,1);
    private static final Date PREMIER_MARS_2001 =  new Date(101,3,1);
    private static final Date PREMIER_MARS_2002 =  new Date(102,3,1);

    private static Date buildDate(int year, int month, int day){

        Calendar cal = new GregorianCalendar();

        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.MONTH, month-1);
        cal.set(Calendar.YEAR, day);

        return cal.getTime();
    }

    private TaxCalculator taxCalculator = new TaxCalculator();

    @Test
    public void testEngineSizeLessThan1550ccAndRegistrionDateBefore200131() {

        Car car = new Car();

        car.setEngineSize(1500);
        car.setRegistrationDate(PREMIER_MARS_2000);

        assertTrue(BigDecimal.valueOf(110L).equals(taxCalculator.calculate(car)));
    }

    @Test
    public void testEngineSizeLessThan1550ccAndRegistrionDateAfter200131() {

        Car car = new Car();

        car.setEngineSize(1500);
        car.setRegistrationDate(PREMIER_MARS_2002);

        Assert.assertFalse(BigDecimal.valueOf(110L).equals(taxCalculator.calculate(car)));
    }

    @Test
    public void testEngineSizeEquals1550cc() {

        Car car = new Car();

        car.setEngineSize(1550);
        car.setRegistrationDate(PREMIER_MARS_2000);

        assertEquals(BigDecimal.valueOf(110L), taxCalculator.calculate(car));
    }
    
    @Test
    public void testEngineSizeGreaterThan1550ccAndRegistrionDateBefore200131() {

        Car car = new Car();

        car.setEngineSize(2000);
        car.setRegistrationDate(PREMIER_MARS_2000);

        assertEquals(BigDecimal.valueOf(165L), taxCalculator.calculate(car));
    }

    @Test
    public void shouldReturn110GBPLessThan1500ccAndFirstMarch2001(){
        Car car = new Car();

        car.setEngineSize(1400);
        car.setRegistrationDate(PREMIER_MARS_2001);

        assertEquals(BigDecimal.valueOf(110L), taxCalculator.calculate(car));
    }

    @Test
    public void shouldReturnTrueForDateEqualsFirstMarch2001() {
        Car car = new Car();
        car.setRegistrationDate(PREMIER_MARS_2001);

        System.out.println(PREMIER_MARS_2001);
        System.out.println(TaxCalculator.CO2_TAX_DATE);

        assertFalse(taxCalculator.isRegistrationDateAfterFirstMarch2001(car));

    }

}
