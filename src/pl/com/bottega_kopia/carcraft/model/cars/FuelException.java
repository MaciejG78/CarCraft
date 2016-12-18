package pl.com.bottega_kopia.carcraft.model.cars;

/**
 * Created by Slawek on 06/11/16.
 */
public class FuelException extends RuntimeException{
    private double missingFuel;

    public FuelException(double missingFuel) {
        super("Not enough fuel. Missing " + missingFuel);
        this.missingFuel = missingFuel;
    }

    public double getMissingFuel() {
        return missingFuel;
    }


}