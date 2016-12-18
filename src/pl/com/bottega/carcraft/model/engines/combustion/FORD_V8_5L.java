package pl.com.bottega.carcraft.model.engines.combustion;

/**
 * Created by Slawek on 12/11/16.
 */
public class FORD_V8_5L extends PetrolEngine{
    private static final double FUEL_CONSUMPTION = 1.5;

    @Override
    public double calculateFuelConsumption(double distance, int rpm) {
        return distance * FUEL_CONSUMPTION * rpm / 1000;
    }

    @Override
    public double getFuelConsumption() {
        return FUEL_CONSUMPTION;
    }
}