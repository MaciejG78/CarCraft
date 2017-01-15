package pl.com.bottega.rekrutacja;

/**
 * Created by macie on 14.01.2017.
 * Napisac klase NumberInfo ktora w konstruktorze przyjmuje jedna liczbe calkowita dodatnia i oferuje
 * trzy metody: getMaxDigit, getMinDigit i getDigitsSum zwracajace opdowiednio maksymalna cyfre,
 * minimalna cyfre oraz sume cyfr liczby z konstruktora.
 */

public class NumberInfo {

    private int number;

    public NumberInfo(int number){
        this.number = number;
    };

    public int getMaxDigit(){
        int lengthNumber  = Integer.toString(number).length();
        int[] tabNumbers = new int[lengthNumber];

        for (int i = 0; i < lengthNumber; i++){
            tabNumbers[i] = number % 10;
            number = number/10;
        }

        int maxNumber = 0;

        for (int i =0; i < lengthNumber; i++){
            if (maxNumber < tabNumbers[i])
                maxNumber = tabNumbers[i];
        }

        return maxNumber;
    }

    public int getMinDigit(){
        int lengthNumber  = Integer.toString(number).length();
        int[] tabNumbers = new int[lengthNumber];

        for (int i = 0; i < lengthNumber; i++){
            tabNumbers[i] = number % 10;
            number = number/10;
        }
        int minNumber = tabNumbers[0];

        for (int i =0; i < lengthNumber; i++){
            if (minNumber > tabNumbers[i])
                minNumber = tabNumbers[i];
        }

        return minNumber;
    }


    public int getDigitSum(){

        return 0;
    }


}
