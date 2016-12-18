package pl.com.bottega.carcraft.model.engines.combustion;

/**
 * Created by macie on 12.11.2016.
 */
public class VAG_30TDI extends DieselEngine{

    private static final double FUEL_CONSUMPTION = 0.05;

    @Override
    public double calculateFuelConsumption(double distance, int rpm) {
        return distance * FUEL_CONSUMPTION * rpm / 1000;
    }

    @Override
    public double getFuelConsumption() {
        return FUEL_CONSUMPTION;
    }
}