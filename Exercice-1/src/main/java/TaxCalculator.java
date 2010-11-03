import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: maximenowak
 * Date: 20 oct. 2010
 * Time: 12:27:17
 * To change this template use File | Settings | File Templates.
 */
public class TaxCalculator {

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

        if (car.getEngineSize() <= 1550) {

            bd = BigDecimal.valueOf(110L);

        } else {

            bd = BigDecimal.valueOf(165L);
        }

        return bd;
    }
}
