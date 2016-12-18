package pl.com.bottega.carcraft.model.engines;

/**
 * Created by Slawek on 12/11/16.
 */
public interface Engine {
    void start();//metody w interfejsą są publiczne domyślnie
    void stop();
    double calculateFuelConsumption(double distance, int rpm);
    boolean isRunning();

    double getFuelConsumption();
}