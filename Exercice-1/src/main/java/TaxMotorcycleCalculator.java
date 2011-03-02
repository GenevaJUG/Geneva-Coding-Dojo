import java.math.BigDecimal;
import java.util.*;

public class TaxMotorcycleCalculator implements TaxCalculator<Motorcycle> {

    protected static List<TaxByMaxValue> taxByEngineSize = new ArrayList<TaxByMaxValue>();

	static {
        taxByEngineSize.add(new TaxByMaxValue(150, "15"));
        taxByEngineSize.add(new TaxByMaxValue(400, "30"));
        taxByEngineSize.add(new TaxByMaxValue(600, "45"));
        taxByEngineSize.add(new TaxByMaxValue(Integer.MAX_VALUE, "60"));
	}

    public BigDecimal calculate(Motorcycle motorcycle) {

        for(TaxByMaxValue taxByMaxValue : taxByEngineSize) {
            if (motorcycle.getEngineSize() <= taxByMaxValue.getMaxValue())
                return taxByMaxValue.getTax();
        }

        throw new IllegalStateException("Should never happen " + motorcycle.getEngineSize());
    }
}
