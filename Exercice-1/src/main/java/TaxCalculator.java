import java.math.BigDecimal;

public interface  TaxCalculator<T extends Vehicle> {

    public BigDecimal calculate(T vehicle);
}
