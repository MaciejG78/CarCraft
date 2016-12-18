package pl.com.bottega_kopia.carcraft.model.engines.combustion;

import pl.com.bottega_kopia.carcraft.model.engines.Engine;

/**
 * Created by macie on 12.11.2016.
 */
public abstract class CombustionEngine implements Engine {
    private boolean isRunning; //domyślnie na fałsz

    protected abstract void init(); //dla potomków - protected

    @Override
    public void start() {
        isRunning = true;
        System.out.println("LOG: starting combution engine");

        init();
    }



    @Override
    public void stop() {
        isRunning = false;
        System.out.println("LOG: shutting down combution engine");

    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }
}
