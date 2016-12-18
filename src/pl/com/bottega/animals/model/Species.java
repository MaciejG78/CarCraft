package pl.com.bottega.animals.model;

import pl.com.bottega.animals.model.breed.Eggborn;
import pl.com.bottega.animals.model.breed.StrategyOfBreed;
import pl.com.bottega.animals.model.breed.Viviparous;
import pl.com.bottega.animals.model.voice.Roar;
import pl.com.bottega.animals.model.voice.Squeak;
import pl.com.bottega.animals.model.voice.StrategyOfVoice;

/**
 * Created by macie on 04.12.2016.
 */
public enum Species implements AnimalConfigurator {
    TIGER("Tygrys bengalski", new Viviparous(), new Roar()),
    LION("Lew australijaski", new Eggborn(), new Squeak()),
    PIG_POLISH_PINK("Swinka polska", new Viviparous(), new Squeak());

    private String name;
    private StrategyOfBreed breed;
    private StrategyOfVoice voice;

    Species(String name, StrategyOfBreed breed ,StrategyOfVoice voice){
        this.name = name;
        this.breed = breed;
        this.voice = voice;

    }

    private Species(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public StrategyOfBreed getStrategyOfBreed(){
        return breed;
    }
    public StrategyOfVoice getStrategyOfVoice(){
        return voice;
    }

}
