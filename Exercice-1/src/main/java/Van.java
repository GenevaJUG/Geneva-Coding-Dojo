public class Van extends Vehicle {

    public Van(int engineSize, int weight) {
        super(engineSize);
        this.weight = weight;
    }

    private int weight;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public VEHICULE_TYPE getType() {
        return Vehicle.VEHICULE_TYPE.VAN;
    }
}
