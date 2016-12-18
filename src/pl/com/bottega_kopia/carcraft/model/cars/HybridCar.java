package pl.com.bottega_kopia.carcraft.model.cars;

import pl.com.bottega_kopia.carcraft.model.engines.combustion.CombustionEngine;
import pl.com.bottega_kopia.carcraft.model.engines.electric.ElectricEngine;

/**
 * Created by macie on 13.11.2016.
 */
public class HybridCar extends Car {

    private static final double ENERGY_CAPACITY = 85;

    protected ElectricEngine electricEngine;

    private double energyLevel; //poziom energii

    //Warto jest zawęzac typy np. CombutionEngine, ElectricEngine
    public HybridCar(BodyType bodyType, CombustionEngine engine, ElectricEngine electricEngine, String name, double fuelLevel, double energyLevel, int x, int y) {
        super(bodyType, engine, name, fuelLevel, x, y);

        if (energyLevel > ENERGY_CAPACITY)
            throw new IllegalArgumentException("Energy level can not exceed " + ENERGY_CAPACITY);

        this.electricEngine = electricEngine;
        this.energyLevel = energyLevel;

    }

    @Override
    public void run() {
        super.run();
        if (!electricEngine.isRunning())
            electricEngine.start();
    }

    @Override
    public void stop() {
        super.stop();
        if (electricEngine.isRunning())
            electricEngine.stop();
    }

    public void charge(double energyQuantity) throws IllegalArgumentException{ //energia którą chcemy dodać to energyQuantity
        double total = energyLevel + energyQuantity;
        if (total > ENERGY_CAPACITY)
            throw new IllegalArgumentException("Total energy " + total + " exceeds capacity " + ENERGY_CAPACITY);
        energyLevel = total;
    }
}