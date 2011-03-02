import java.math.BigDecimal;

public class TaxVanCalculator implements TaxCalculator<Van> {

	public BigDecimal calculate(Van van) {
		if (van.getWeight() < 3500) {
			return BigDecimal.valueOf(165L);
		}
		return BigDecimal.valueOf(190L);
	}
}
