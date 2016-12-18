package pl.com.bottega.carcraft.model.cars;

import pl.com.bottega.carcraft.model.engines.combustion.BMW_N55;
import pl.com.bottega.carcraft.model.engines.combustion.FORD_V8_5L;
import pl.com.bottega.carcraft.model.engines.combustion.PORSCHE_3L;
import pl.com.bottega.carcraft.model.engines.combustion.PetrolEngine;
import pl.com.bottega.carcraft.model.engines.electric.ElectricEngine;

//idiom
public class CarsFactory {
    private static int number = 1000;
    /**
     *
     * @param model
     * @param x
     * @param y
     * @param fuelPercentage 0..100
     * @return
     * @throws IllegalArgumentException
     */
    //<L> Car<L> Pierwsze L ustawia metodę na generyczną, drugie L oznacza, że Car jest generyczny
    public static <L> Car<L> create(String model, double fuelPercentage, int x, int y, L load) throws IllegalArgumentException{
        if (x<0 || y<0)
            throw new IllegalArgumentException("Coordinates can not be negative");
        if (fuelPercentage<0 || fuelPercentage>100)
            throw new IllegalArgumentException("persentage shuld be in range [0, 100]");

        double fuelLevel = Car.FUEL_CAPACITY * fuelPercentage / 100;
        Car<L> car;

        switch(model){
            case "mustang":
                car = new Car<L>(BodyType.ROADSTER, new FORD_V8_5L(), "mustang", fuelLevel, x, y);
                car.put(load);
                return car;
            case "911":
                car = new Car<L>(BodyType.CABRIO, new PORSCHE_3L(), "911", fuelLevel, x, y);
                car.put(load);
                return car;
            case "prius":
                //   throw new RuntimeException("i'm stupid");
                car = new HybridCar<L>(BodyType.HATCHBACK, new BMW_N55(), new ElectricEngine(), "bazyliszek", fuelLevel, 10, x, y);
                car.put(load);
                return car;
            case "i8":
                car = new HybridCar<L>(BodyType.ROADSTER, new BMW_N55(), new ElectricEngine(), "spaceship", fuelLevel, 3, x, y);
                car.put(load);
                return car;
            default:
                throw new IllegalArgumentException("model " + model + " is unknown");
        }
    }

    private static RegistrationNumber generateRegistrationNumber(){
        return new RegistrationNumber("LU", String.valueOf(number++));
    }
}