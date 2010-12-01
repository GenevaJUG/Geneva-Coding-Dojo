import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
		if (van.getWeight() < 3500) {
			return BigDecimal.valueOf(165L);
		}
		return BigDecimal.valueOf(190L);
	}

	public BigDecimal calculate(Car car) {
		if (isRegistrationDateAfterFirstMarch2001(car)) {
			return BigDecimal.ZERO;
		}
		if (car.getEngineSize() <= 1550) {
			return BigDecimal.valueOf(110L);
		}
		return BigDecimal.valueOf(165L);
	}

	protected boolean isRegistrationDateAfterFirstMarch2001(Car car) {
		return car.isRegisteredAfter(CO2_TAX_DATE);
	}
}
