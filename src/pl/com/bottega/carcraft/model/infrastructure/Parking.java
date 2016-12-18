package pl.com.bottega.carcraft.model.infrastructure;

import pl.com.bottega.carcraft.model.cars.RegistrationNumber;
import pl.com.bottega.carcraft.model.cars.Car;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by macie on 19.11.2016.
 */
public class Parking {

    private Map<RegistrationNumber, Car> slots = new HashMap<>();
    private int capacity;
    private int currentOccupation;


    public boolean park(Car car){
        //Sprawdzenie capacity,
        // włożenie do mapy
        // zwiększenie current
        return true;

    }

    public void leave(Car car){
        //sprawdzenie czy stoję,
        //usunięcie z mapy
        //zmniejszenie current;

    }

}
