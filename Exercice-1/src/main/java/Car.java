import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: maximenowak
 * Date: 20 oct. 2010
 * Time: 13:10:28
 * To change this template use File | Settings | File Templates.
 */
public class Car {
    private Date registrationDate;

    public int getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(int engineSize) {
        this.engineSize = engineSize;
    }

    private int engineSize;

    public void setRegistrationDate(Date date) {
        this.registrationDate = date;
    }
}
