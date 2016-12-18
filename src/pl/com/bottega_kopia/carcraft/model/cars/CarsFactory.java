package pl.com.bottega_kopia.carcraft.model.cars;

import pl.com.bottega_kopia.carcraft.model.engines.combustion.BMW_N55;
import pl.com.bottega_kopia.carcraft.model.engines.combustion.VAG_30TDI;
import pl.com.bottega_kopia.carcraft.model.engines.electric.ElectricEngine;

/**
 * Created by macie on 13.11.2016.
 */

//idiom Fabryki
public class CarsFactory {
    /**
     *
     * @param model
     * @param x
     * @param y
     * @param fuelPercentage 0..100
     * @return
     * @throws IllegalArgumentException
     */
    public static Car create(String model, int x, int y, double fuelPercentage) throws IllegalArgumentException{
        if (x<0 || y<0)
            throw new IllegalArgumentException("Coordinates can not be negative");

        if (fuelPercentage < 0 || fuelPercentage > 100)
            throw new IllegalArgumentException("Percentage should be in range [0, 100]");

            double fuelLevel = Car.FUEL_CAPACITY * fuelPercentage / 100;


        switch(model) {  //Od java 8 można przełaczac się po stringach wcześniej trzeba było stosować if-y
            case "prius":
                //assert fuelLevel <= Car.FUEL_CAPACITY);
                //throw new RuntimeException("I'm stupid");
                return new HybridCar(BodyType.HATCHBACK, new VAG_30TDI(), new ElectricEngine(), "bazyliszek", 10, 10, x, y);
            case "i8":
                return new HybridCar(BodyType.ROADSTER, new BMW_N55(), new ElectricEngine(), "spaceship", 3, 3, x, y);
            default:
                throw new IllegalArgumentException("model " + model + " is unknown");
        }
    }
}
