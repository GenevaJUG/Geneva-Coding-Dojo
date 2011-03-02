import java.util.Date;

public class Car extends Vehicle {

	private final Date registrationDate;

	public Car(Date registrationDate, int engineSize) {
        super(engineSize);
		this.registrationDate = registrationDate;
	}

	public boolean isRegisteredAfter(Date date) {
		return registrationDate.compareTo(date) >= 0;
	}

	public int getCO2() {
		throw new UnsupportedOperationException();
	}

    @Override
    public VEHICULE_TYPE getType() {
        return VEHICULE_TYPE.CAR;
    }
}
