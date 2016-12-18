package pl.com.bottega.animals.model.breed;

import pl.com.bottega.animals.model.Animal;

/**
 * Created by macie on 04.12.2016.
 */
public class Eggborn implements StrategyOfBreed{

    @Override
    public void breed(Animal animal) {
        System.out.println("Jajorodny");
    }
}
