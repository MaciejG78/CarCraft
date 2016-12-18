package pl.com.bottega.carcraft.model.engines.combustion;

/**
 * Created by macie on 12.11.2016.
 */
public abstract class DieselEngine extends CombustionEngine {


    @Override
    protected void init() {
        System.out.println("LOG: żarniki działają");
    }
}
