package pl.com.bottega_kopia.carcraft.model.engines.electric;

import pl.com.bottega_kopia.carcraft.model.engines.Engine;

/**
 * Created by macie on 12.11.2016.
 */
public class ElectricEngine implements Engine {
    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public double calculateFuelconsumption(double distance, int rpm) {
        return 0;
    }

    @Override
    public boolean isRunning() {
        return false;
    }
}