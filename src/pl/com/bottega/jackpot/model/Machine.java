package pl.com.bottega.jackpot.model;

import pl.com.bottega.jackpot.application.Application;
import pl.com.bottega.jackpot.model.devices.DisplayDevice;

import java.util.*;


/**
 * Created by macie on 20.11.2016.
 */
public class Machine implements MaintenacePanel, GamerPanel {

    //===================== pola ==============================
    private Set<Money> acceptableCoins= new HashSet<>(Arrays.asList(
            new Money("1", "PLN"),
            new Money("2", "PLN"),
            new Money("5", "PLN")));

    private Money gameCost;
    private Money moneyForTheGame = Money.ZERO;
    private Money numberOfTheGames = Money.ZERO;
    private int NUMBER_OF_MONEY_START = Application.NUMBER_OF_MONEY_START;
    private int TOTAL_WIN_MONEY = Application.VALUE_OF_MULTIPLIER_AMOUNTS;

    private Map<Money, Integer> cartrige = new HashMap<>();

    private DisplayDevice displayDevice;

    public Machine(DisplayDevice displayDevice) {
        this.displayDevice = displayDevice;
    }


    //================================ Panel admina =================================================
    @Override
    public void changeSettings(Set<Money> coins, Money gameCost) {
        //TODO Czy da się zapłacić koszt jednej gry możliwymi monetami? Jeśli tak to zmienić możliwe monety i zmień koszt

        if (cartrige == null)
            throw new IllegalStateException("Machine is no ready, cartridge is missing");

        if (cartrige.keySet().containsAll(coins))
            throw new IllegalArgumentException("cartridge can not hold these coins");


        //defensywne kopiowanie aby uodpornic się na zmiany zbioru poza Machine
        this.acceptableCoins = new LinkedHashSet<>(coins); //stworzyliśmy kopię coinsów, żeby nam ktoś nie zmienił danych w coins poza machine (defensywne kopiowanie
        this.gameCost = gameCost;
    }
    //Ustawiamy cenę jednej gry
    private void changeGameCost(Money cost){
    //sprawdzić czy ten koszt da się zapłacić możliwymi monetami

    }

    private void changeAcceptableCoins(Set<Money> coins){

    }

    //Mapa zawierająca ilość poszczególnych monet
    @Override
    public Map<Money, Integer> getMoneyReport(){
        //return cartrige; można tak wpisać ale zwrócilibyśmy referencję bez możliwości zmiany
        return new HashMap<>(cartrige); //defensywna kopia
    }

    //Cała kwota w kasetce
    @Override
    public Money getTotalValue(){
        Money sum = Money.ZERO; //Zaczynamy od zera
        Set<Money> keys = cartrige.keySet(); //rejestr kluczy z mapy (typy monet)
        for (Money key : keys){//dla każdej typu monety
            int counter = cartrige.get(key); //wybieramy wartość pod kluczem (ilość poszczególnych typów monet)
            Money summand = key.multiply(counter); //Pieniądz został pomnożony (wartość poszczególnych monet)
            sum = sum.add(summand); //dodajemy obliczoną wartość sumy do ogólnej sumy całościowej
        }

        return sum;
    }

    //Zmiana stanu kasy w kasetce - wypłata przez admina - stan początkowy - każdej monety po 10 szt.
    @Override
    public void changeMoneyState(Money key){
        cartrige.put(key, NUMBER_OF_MONEY_START);

    }


    //================================== Panel gracza =================================

    @Override
    public void topUp(Money value){
        //czy dozwolona moneta, jeżeli nie wypluwa(zwraca)
        //modyfikujemy "kasetkę"

        if (acceptableCoins.contains(value)) {
            cartrige.put(value, cartrige.get(value) + 1 );
            //podsumowanie ile zapłacono (pole)
            //przeliczyć możliwe gry biorąc pod uwagę koszt (pole)
            //przeliczam ilość gier i wyświetlam ilość gier na interfejsie wyświetlacza
            moneyForTheGame = moneyForTheGame.add(value);
            numberOfTheGames = moneyForTheGame.div(gameCost);
          }

       else {
            System.out.println("Moneta niedozwolona - ZWROT !!!");
            }
        System.out.println("Kwota wpłacona to: " + moneyForTheGame + ", Możesz grać: " + numberOfTheGames.getValue() + " razy.");

    }

    @Override
    public void play() {
        Random r = new Random(); //deklaracja metody Random

        //sprawdzić ilość gier, czy ilość gier >= 1
        if (numberOfTheGames.equals(Money.ZERO)) {
            System.out.println("Nie masz kasy na granie, wpłać albo do roboty");
        } else {
            moneyForTheGame = moneyForTheGame.minus(gameCost);
            numberOfTheGames = moneyForTheGame.div(gameCost);

            //zbadać ilośc kręciołków - to wie wyświetlacz
            //losujemy z możliwych obrazków tyle razy ile jest kręciołków

            //tyle jest możliwych "kręciołków" (okienek)
            int randomWindows = displayDevice.getRandomWindowsCount();

            //tyle możliwych wartości ma jeno "okienko" losowania
            int randomElements = displayDevice.getRandomElementsCount();

            int[] randomResult = new int[randomWindows];//tutaj będą wyniki losowania każdego okienka

            //wyświetlenie wyniku (po interfejsie) - na wyświetlaczu
            for (int i = 0; i < randomResult.length; i++) {
                randomResult[i] = (int) r.nextInt(randomElements);

            }

            int min = Arrays.stream(randomResult).min().getAsInt();
            int max = Arrays.stream(randomResult).max().getAsInt();

            System.out.println("Pozostało Ci: " + moneyForTheGame + ", Możesz grać: " + numberOfTheGames + " razy.");

            payMoneyForWin(randomResult, min, max);

        }

    }

    private void payMoneyForWin(int[] randomResult, int min, int max) {
        if (min == max) {
            Money sumOfMoneyWin = Money.ZERO;
            displayDevice.displayWin(randomResult);
            //zapytanie silnika reguł ile wygrywamy - ustawione jest po 5 szt każdej  monety
            //wysypanie monet i zmiana ilości w kartridżu
            Set<Money> keys = cartrige.keySet(); //rejestr kluczy z mapy (typy monet)
            for (Money key : keys) {//dla każdej typu monety
                cartrige.put(key, cartrige.get(key) - Application.VALUE_OF_MULTIPLIER_AMOUNTS);
                Money multiplyKey = key.multiply(Application.VALUE_OF_MULTIPLIER_AMOUNTS);
                sumOfMoneyWin = sumOfMoneyWin.add(multiplyKey);
            }
            System.out.println();
            System.out.println("BRAWO wypłacamy: " + sumOfMoneyWin);

    }
        else {
            displayDevice.displayFail(randomResult);
            System.out.println();
        }
    }
}
