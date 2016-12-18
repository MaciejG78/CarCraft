package pl.com.bottega_kopia.carcraft.model.engines.combustion;

/**
 * Created by macie on 12.11.2016.
 */
public class VAG_30TDI extends DieselEngine {

    private static final double FUEL_CONSUMPTION = 1.5;
    @Override
    public double calculateFuelconsumption(double distance, int rpm) {
        return distance * FUEL_CONSUMPTION * rpm / 1000;
    }
}
