import java.util.HashMap;
import java.util.Map;

public class TaxCalculatorFactory {


    private Map<Vehicle.VEHICULE_TYPE, TaxCalculator> calculatorByVehicle = new HashMap<Vehicle.VEHICULE_TYPE, TaxCalculator>() {{
        put(Vehicle.VEHICULE_TYPE.CAR, new TaxCarCalculator());
        put(Vehicle.VEHICULE_TYPE.VAN, new TaxVanCalculator());
        put(Vehicle.VEHICULE_TYPE.MOTORCYCLE, new TaxMotorcycleCalculator());
    }};

    public TaxCalculator getCalculator(Vehicle vehicle) {
        return calculatorByVehicle.get(vehicle.getType());
    }
}
