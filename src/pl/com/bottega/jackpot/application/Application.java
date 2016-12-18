package pl.com.bottega.jackpot.application;

import pl.com.bottega.jackpot.model.GamerPanel;
import pl.com.bottega.jackpot.model.Machine;
import pl.com.bottega.jackpot.model.MaintenacePanel;
import pl.com.bottega.jackpot.model.Money;
import pl.com.bottega.jackpot.model.devices.FakeConsoleDisplayDevice;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


/**
 * Created by macie on 21.11.2016.
 * Jednoręki bandyta
 */
public class Application {

    private static final Money GAME_COST = new Money("2", "PLN");
    public static final int VALUE_OF_MULTIPLIER_AMOUNTS = 5; //Mnożnik do wypłaty w przypadku wygranej np. 1 PLN * 5 + 2 PLN * 5 + 5 PLN * 5 = 40 PLN
    public static final int NUMBER_OF_MONEY_START = 10; //Ilość monet na początku gry, każdej monety po np. 10 szt.
    private static final Set<Money> AVAILABLE_COINS = new HashSet<>(Arrays.asList(
            new Money("1", "PLN"),
            new Money("2", "PLN"),
            new Money("5", "PLN")));

    public static void main(String[] args) {
        Machine machine = new Machine(new FakeConsoleDisplayDevice());

        simulateAdminSetupBahavior(machine);
        simulateGamerBehavior(machine);
        simulateAdminHarvestBehavior(machine);
    }

    private static void simulateAdminHarvestBehavior(MaintenacePanel machine) {
        Money value = machine.getTotalValue();
        System.out.println("Total money: " + value);
        machine.getMoneyReport();
    }

    private static void simulateGamerBehavior(GamerPanel machine) {

        try {
            byte go = 1;
            do {
                //System.out.print("\033[2J");//clear console
                System.out.print("\033[H\033[2J");
                System.out.flush();

                char character = readKey();

             switch (character) {
                    case '1':
                        machine.topUp(new Money("1", "PLN"));// sprawdzenie monety
                        break;
                    case '2':
                        machine.topUp(new Money("2", "PLN"));// sprawdzenie monety
                        break;
                    case '3':
                     machine.topUp(new Money("3", "PLN"));// sprawdzenie monety
                     break;
                    case '4':
                     machine.topUp(new Money("4", "PLN"));// sprawdzenie monety
                     break;
                    case '5':
                        machine.topUp(new Money("5", "PLN"));// sprawdzenie monety
                        break;
                     case '6':
                         machine.topUp(new Money("6", "PLN"));// sprawdzenie monety
                         break;
                     case '7':
                         machine.topUp(new Money("7", "PLN"));// sprawdzenie monety
                         break;
                     case '8':
                         machine.topUp(new Money("8", "PLN"));// sprawdzenie monety
                         break;
                     case '9':
                         machine.topUp(new Money("9", "PLN"));// sprawdzenie monety
                         break;
                    case 'p':
                        machine.play();
                        break;
                    case 'q':
                        go = 0;
                        break;
                    default:
                        System.out.println("-------Wybrano niewłaściwy klawisz !!!---------");
                        System.out.println("----------------Ponów próbę -------------------");
                        //kod który wykona się gdy nic nie pasuje

                }

            } while (go == 1);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void simulateAdminSetupBahavior(MaintenacePanel machine) {
        machine.changeSettings(AVAILABLE_COINS, GAME_COST);
        machine.changeMoneyState(new Money("1", "PLN"));
        machine.changeMoneyState(new Money("2", "PLN"));
        machine.changeMoneyState(new Money("5", "PLN"));
    }

    private static char readKey() throws IOException {
        Scanner s = new Scanner(System.in);
        char ch = s.next().charAt(0);
        return ch;
    }
}



