package pl.com.bottega.animals.application;

import pl.com.bottega.animals.model.Animal;
import pl.com.bottega.animals.model.AnimalsFactory;
import pl.com.bottega.animals.model.Species;

/**
 * Created by macie on 04.12.2016.
 */
public class AnimalApp {

    public static void main(String[] args) {

        Animal animal = null;

        animal = AnimalsFactory.create(Species.LION);
        System.out.println();
        animal.voice();
        animal.breed();



    }
}
