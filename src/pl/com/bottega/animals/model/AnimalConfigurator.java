package pl.com.bottega.animals.model;

import pl.com.bottega.animals.model.breed.StrategyOfBreed;
import pl.com.bottega.animals.model.voice.StrategyOfVoice;

/**
 * Created by macie on 04.12.2016.
 */
public interface AnimalConfigurator {
    public String getName();
    public StrategyOfBreed getStrategyOfBreed();
    public StrategyOfVoice getStrategyOfVoice();

}
