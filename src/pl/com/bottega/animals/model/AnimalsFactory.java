package pl.com.bottega.animals.model;

import pl.com.bottega.animals.model.breed.Eggborn;
import pl.com.bottega.animals.model.breed.Viviparous;
import pl.com.bottega.animals.model.voice.Roar;
import pl.com.bottega.animals.model.voice.Squeak;

/**
 * Created by macie on 04.12.2016.
 */
public class AnimalsFactory {

    public static Animal create(AnimalConfigurator species){
        return new Animal(species.getName(), species.getStrategyOfBreed(), species.getStrategyOfVoice());


    }
}
