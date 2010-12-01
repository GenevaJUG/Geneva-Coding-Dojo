import static org.junit.Assert.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;

public class CarTest {
	@Test
	public void canGetEngineSize() {
		Car car = new Car(null, 1550);

		int engineSize = car.getEngineSize();

		assertEquals(1550, engineSize);
	}
	
	@Test
	public void canBeRegisteredBeforeLimitDate() throws ParseException {
		Date dateBeforeLimitDate = date("01/01/2000");
		Date limitDate = date("01/01/2002");

		Car car = new Car(dateBeforeLimitDate, 1550);
		boolean isRegisteredAfter = car.isRegisteredAfter(limitDate);
		
		assertFalse(isRegisteredAfter);
	}

	@Test
	public void canBeRegisteredAfterLimitDate() throws ParseException {
		Date dateAfterLimitDate = date("01/01/2012");
		Date limitDate = date("01/01/2002");

		Car car = new Car(dateAfterLimitDate, 1550);
		boolean isRegisteredAfter = car.isRegisteredAfter(limitDate);
		
		assertTrue(isRegisteredAfter);
	}
	
	@Test
	public void registrationOnLimitDateIsConsiredredAfter() throws ParseException {
		Date limitDate = date("01/01/2002");
		
		Car car = new Car(limitDate, 1550);
		boolean isRegisteredAfter = car.isRegisteredAfter(limitDate);
		
		assertTrue(isRegisteredAfter);
	}
	
	private static Date date(String date) throws ParseException {
		return new SimpleDateFormat("dd/MM/yyyy").parse(date);
	}
}
