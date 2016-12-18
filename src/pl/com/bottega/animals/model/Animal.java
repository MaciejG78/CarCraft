package pl.com.bottega.animals.model;

import pl.com.bottega.animals.model.breed.StrategyOfBreed;
import pl.com.bottega.animals.model.voice.StrategyOfVoice;

/**
 * Created by macie on 04.12.2016.
 */
public class Animal {
    private String name;

    private StrategyOfBreed breedable; //Pole strategii rozmnażania się
    private StrategyOfVoice voiceable; //Pole strategii wydawania dźwięku

    Animal(String name, StrategyOfBreed breedeable, StrategyOfVoice voiceable){
        this.name = name;
        this.breedable = breedeable;
        this.voiceable = voiceable;

    }
    public void voice(){
        //...
        voiceable.voice(this);
    }

    public void breed() {
        //...
        breedable.breed(this);
    }

    public String toString(){
        return "Nazwa: " + name + ", Sposób rozmnażania: " + breedable + "Rodzaj dźwięku: " + voiceable;
    }
}
