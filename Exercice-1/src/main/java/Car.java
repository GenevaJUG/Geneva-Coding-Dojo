import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: maximenowak
 * Date: 20 oct. 2010
 * Time: 13:10:28
 * To change this template use File | Settings | File Templates.
 */
public class Car {
    public Car(Date registrationDate, int engineSize) {
		this.registrationDate = registrationDate;
		this.engineSize = engineSize;
	}

	public Car(Date date, int size, int co2) {
		// TODO Auto-generated constructor stub
	}

	private Date registrationDate;
    private int engineSize;

    public int getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(int engineSize) {
        this.engineSize = engineSize;
    }


    public void setRegistrationDate(Date date) {
        this.registrationDate = date;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }
}
