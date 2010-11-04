import org.apache.commons.lang.time.DateUtils;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by IntelliJ IDEA.
 * User: maximenowak
 * Date: 20 oct. 2010
 * Time: 12:27:17
 * To change this template use File | Settings | File Templates.
 */
public class TaxCalculator {

    protected static final Date CO2_TAX_DATE;

    static {

        Calendar cal = new GregorianCalendar();

        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.MONTH, Calendar.MARCH);
        cal.set(Calendar.YEAR, 2001);

        CO2_TAX_DATE = cal.getTime();
    }

    public BigDecimal calculate(Van van) {

        BigDecimal bd;

        if (van.getWeight() < 3500) {

            bd = BigDecimal.valueOf(165L);

        } else {

            bd = BigDecimal.valueOf(190L);
        }

        return bd;
    }
    public BigDecimal calculate(Car car) {

        BigDecimal bd;

        if (isRegistrationDateAfterFirstMarch2001(car)) {
            bd = BigDecimal.ZERO;
        }
        else {
            if (car.getEngineSize() <= 1550) {

                bd = BigDecimal.valueOf(110L);

            } else {

                bd = BigDecimal.valueOf(165L);
            }
        }

        return bd;
    }



    protected boolean isRegistrationDateAfterFirstMarch2001(Car car) {

   
        return car.getRegistrationDate().after(CO2_TAX_DATE);
    }
}
