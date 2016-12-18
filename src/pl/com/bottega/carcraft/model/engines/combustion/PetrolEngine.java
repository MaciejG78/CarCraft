package pl.com.bottega.carcraft.model.engines.combustion;

/**
 * Created by Slawek on 12/11/16.
 */
public abstract class PetrolEngine extends CombustionEngine{
    @Override
    protected void init() {
        System.out.println("LOG: zapłon działa");
    }
}