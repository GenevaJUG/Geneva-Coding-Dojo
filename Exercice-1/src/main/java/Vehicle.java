public abstract class Vehicle {

    public enum VEHICULE_TYPE { CAR, VAN, MOTORCYCLE };

    private int engineSize;

    public int getEngineSize() {
        return engineSize;
    }

    protected Vehicle(int engineSize) {
        this.engineSize = engineSize;
    }

    public abstract VEHICULE_TYPE getType();
}
