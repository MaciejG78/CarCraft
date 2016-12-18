package pl.com.bottega_kopia.carcraft.model.engines.combustion;

/**
 * Created by macie on 12.11.2016.
 */
public abstract class PetrolEngine extends CombustionEngine {


    @Override
    protected void init() {
        System.out.println("LOG: zapłon działa");
    }
}
