package pl.com.bottega.carcraft.model.engines.electric;

import pl.com.bottega.carcraft.model.engines.Engine;

/**
 * Created by Slawek on 13/11/16.
 */
public class ElectricEngine implements Engine{
    protected boolean isRunning;//domyslnie false
    @Override
    public void start() {
        isRunning = true;
        System.out.println("LOG: starting electric engine");
        init();
    }

    @Override
    public void stop() {
        isRunning = false;
        System.out.println("LOG: shutting down electric engine");
    }

    @Override
    public double calculateFuelConsumption(double distance, int rpm) {
        return 0;
    }

    @Override
    public boolean isRunning() {
        return isRunning();
    }

    @Override
    public double getFuelConsumption() {
        return 0;
    }

    protected void init() {
        System.out.println("LOG: baterie działają");
    }
}