package pl.com.bottega.animals.model.voice;

import pl.com.bottega.animals.model.Animal;

/**
 * Created by macie on 04.12.2016.
 */
public class Roar implements StrategyOfVoice{


    @Override
    public void voice(Animal animal) {
        System.out.println("Ryczy");
    }
}
