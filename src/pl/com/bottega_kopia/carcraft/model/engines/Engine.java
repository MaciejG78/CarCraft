package pl.com.bottega_kopia.carcraft.model.engines;

/**
 * Created by macie on 12.11.2016.
 */
public interface Engine {
    void start(); //metody w interfejsach są publiczne domyślnie
    void stop();
    double calculateFuelconsumption(double distance, int rpm);
    boolean isRunning(); //Jak zaczyna się od is jest to metoda boolowska


}
