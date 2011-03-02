public class Motorcycle extends Vehicle {

    public Motorcycle(int engineSize) {
        super(engineSize);
    }

    @Override
    public VEHICULE_TYPE getType() {
        return Vehicle.VEHICULE_TYPE.MOTORCYCLE;
    }
}
