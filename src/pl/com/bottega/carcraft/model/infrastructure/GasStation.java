package pl.com.bottega.carcraft.model.infrastructure;

import pl.com.bottega.carcraft.model.cars.BodyType;
import pl.com.bottega.carcraft.model.cars.Car;
import pl.com.bottega.carcraft.model.cars.HybridCar;
import pl.com.bottega.carcraft.model.engines.Engine;

/**
 * Created by Slawek on 13/11/16.
 */
public class GasStation {
    private double fuelCapacity;
    private double energyCapacity;
    private int x, y;


    private static void validate(int x, int y) {
        if (x < 0 || y < 0)
            throw new IllegalArgumentException();
    }


    public static GasStation createSmall(int x, int y){
        validate(x, y);
        return new GasStation(30000, 2000, x, y);
    }

    public static GasStation createMedium(int x, int y){
        validate(x, y);
        return new GasStation(50000, 4000, x, y);
    }

    public static GasStation createLarge(int x, int y){
        validate(x, y);
        return new GasStation(90000, 6000, x, y);
    }


    public GasStation(double fuelCapacity, double energyCapacity) {
        this.fuelCapacity = fuelCapacity;
        this.energyCapacity = energyCapacity;
    }

    private String nameGasStation;


    }

    public void fullService(Car car){
        /*
        double amount = car.getFuelCapacity() - car.getFuelLevel();
        car.fill(amount);
        if (car instanceof HybridCar){
            HybridCar hybrid = (HybridCar) car;
            double kwh = hybrid.getEnergyCapacity() - hybrid.getEnergyLevel();
            hybrid.charge(kwh);
        }*/
    }

    public int getX(){ return x; }

    public int getY(){
        return y;
    }
}