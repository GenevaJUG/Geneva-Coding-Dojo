import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: codingdojo
 * Date: 2/9/11
 * Time: 12:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class TaxByMaxValue {

    private int maxValue;
    private BigDecimal tax;

    TaxByMaxValue(int maxValue, String tax) {
        this.maxValue = maxValue;
        this.tax = new BigDecimal(tax);
    }

    public int getMaxValue() {
        return maxValue;
    }

    public BigDecimal getTax() {
        return tax;
    }
}
