package pl.com.bottega.jackpot.model;

import java.util.Map;
import java.util.Set;

/**
 * Created by macie on 20.11.2016.
 */
public interface MaintenacePanel {
    void changeSettings(Set<Money> coins, Money gameCost);

    //Mapa zawierająca ilość poszczególnych monet
    Map<Money, Integer> getMoneyReport();

    //Cała kwota w kasetce
    Money getTotalValue();

   //Zmiana stanu kasetki
    void changeMoneyState(Money key);
}


