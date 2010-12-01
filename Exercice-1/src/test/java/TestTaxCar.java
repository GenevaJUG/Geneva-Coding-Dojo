import static org.fest.assertions.Assertions.*;
import static org.mockito.Mockito.*;
import java.math.BigDecimal;
import org.junit.Test;

public class TestTaxCar {
	private TaxCalculator taxCalculator = new TaxCalculator();

	@Test
	public void testEngineSizeLessThan1550ccAndRegisteredBeforeMarch2001() {
		Car car = carBeforeMarch2001WithEngineSize(1000);

		BigDecimal tax = taxCalculator.calculate(car);

		assertThat(tax).isEqualTo(new BigDecimal("110"));
	}
	
	@Test
	public void testEngineSize1550ccAndRegisteredBeforeMarch2001() {
		Car car = carBeforeMarch2001WithEngineSize(1550);
		
		BigDecimal tax = taxCalculator.calculate(car);
		
		assertThat(tax).isEqualTo(new BigDecimal("110"));
	}

	@Test
	public void testEngineSizeOver1550ccAndRegisteredBeforeMarch2001() {
		Car car = carBeforeMarch2001WithEngineSize(2000);
		
		BigDecimal tax = taxCalculator.calculate(car);
		
		assertThat(tax).isEqualTo(new BigDecimal("165"));
	}

	@Test
	public void testEngineSizeLessThan1550ccAndRegisteredAfterMarch2001() {
		Car car = carAfterMarch2001WithEngineSize(1550);

		BigDecimal tax = taxCalculator.calculate(car);
		
		assertThat(tax).isNotEqualTo(new BigDecimal("1100"));
	}
	
	@Test
	public void testEngineWithCO2_100() {
		Car car = carWithCo2(100);

		BigDecimal tax = taxCalculator.calculate(car);
		
		assertThat(tax).isEqualTo(new BigDecimal("65"));
	}

	private Car carWithCo2(int co2) {
		Car car = mock(Car.class);
		when(car.getCO2()).thenReturn(co2);
		when(car.isRegisteredAfter(TaxCalculator.CO2_TAX_DATE)).thenReturn(true);
		return car;
	}

	private static Car carBeforeMarch2001WithEngineSize(int engineSize) {
		Car car = mock(Car.class);
		when(car.getEngineSize()).thenReturn(engineSize);
		return car;
	}

	private static Car carAfterMarch2001WithEngineSize(int engineSize) {
		Car car = mock(Car.class);
		when(car.getEngineSize()).thenReturn(engineSize);
		when(car.isRegisteredAfter(TaxCalculator.CO2_TAX_DATE)).thenReturn(true);
		return car;
	}
}
