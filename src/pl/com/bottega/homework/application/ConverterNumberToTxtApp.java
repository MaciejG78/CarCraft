package pl.com.bottega.homework.application;
import pl.com.bottega.homework.model.ConverterNumberToTxt;

import java.util.Scanner;
/**
 * Created by macie on 26.11.2016.
 */
public class ConverterNumberToTxtApp {

    private static String quitTest = "t";

    public static void main(String[] args) {


        while (!quitTest.equals("q")) {
            Scanner input = new Scanner(System.in);
            System.out.println("Podaj liczbę do konwersji na tekst: ");
            Long numberToConvert = input.nextLong();
            String resultsInTxt = ConverterNumberToTxt.converterNumbersToTxt(numberToConvert);
            System.out.println("Twoja liczba to: " + resultsInTxt);
            System.out.println();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Czy chcesz kontynuować z kolejną liczbą? Jak tak wprowadź dowolny znak, jeśli chcesz wyjść to wprowadź 'q'.");
            quitTest = scanner.nextLine();
        }

    }
}