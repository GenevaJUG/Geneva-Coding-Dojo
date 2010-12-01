import static org.fest.assertions.Assertions.*;
import java.math.BigDecimal;
import java.util.Date;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class TestsDeRecette {
	private static final Date MARCH_2001 = new Date(2001, 3, 1);
	private static final Date FEB_2001 = new Date(2001, 2, 28);

	@DataPoint
	public static Data beforeMarch2001_Under1550 = new Data(FEB_2001, 1500, 0, "110");
	@DataPoint
	public static Data beforeMarch2001_Over1550 = new Data(FEB_2001, 3000, 0, "165");
	@DataPoint
	public static Data afterMarch2001WithCO2Of100= new Data(MARCH_2001, 0, 100, "65");
	@DataPoint
	public static Data afterMarch2001WithCO2Of120= new Data(MARCH_2001, 0, 120, "75");
	@DataPoint
	public static Data afterMarch2001WithCO2Of150= new Data(MARCH_2001, 0, 150, "105");
	@DataPoint
	public static Data afterMarch2001WithCO2Of165= new Data(MARCH_2001, 0, 165, "125");
	@DataPoint
	public static Data afterMarch2001WithCO2Of185= new Data(MARCH_2001, 0, 185, "145");
	@DataPoint
	public static Data afterMarch2001WithCO2Of200= new Data(MARCH_2001, 0, 200, "160");

	@Theory
	public void canComputeTax(Data data) {
		Car car = new Car(data.date, data.size, data.co2);

		TaxCalculator taxCalculator = new TaxCalculator();
		BigDecimal tax = taxCalculator.calculate(car);

		assertThat(tax).isEqualTo(new BigDecimal(data.expectedTax));
	}

	static class Data {
		Date date;
		int size;
		int co2;
		String expectedTax;

		public Data(Date date, int size, int co2, String expectedTax) {
			this.date = date;
			this.size = size;
			this.co2 = co2;
			this.expectedTax = expectedTax;
		}
	}
}
