package pl.com.bottega.jackpot.model.devices;

/**
 * Created by macie on 21.11.2016.
 */
public interface DisplayDevice { //wyświetlacz

        int getRandomWindowsCount();

        int getRandomElementsCount();

        void displayWin(int[] results);

        void displayFail(int[] results);
}
