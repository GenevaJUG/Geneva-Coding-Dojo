import java.util.Date;

public class Car {
	private final Date registrationDate;
	private final int engineSize;

	public Car(Date registrationDate, int engineSize) {
		this.registrationDate = registrationDate;
		this.engineSize = engineSize;
	}

    public int getEngineSize() {
        return engineSize;
    }

	public boolean isRegisteredAfter(Date date) {
		return registrationDate.compareTo(date) >= 0;
	}

	public int getCO2() {
		throw new UnsupportedOperationException();
	}
}
