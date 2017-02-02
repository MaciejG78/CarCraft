package pl.com.bottega.javastart.tests;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by macie on 26.01.2017.
 */
public class sumNumbers {
    public static final String EXIT = "exit";

    public static void main(String[] args) {
        List<Double> numbers = new LinkedList<>();
        try (Scanner sc = new Scanner(System.in);) {
            readData(sc, numbers);
        }
        printData(numbers);
    }

    //metoda rekurencyjna do wczytywania danych
    static void readData(Scanner sc, List<Double> list) {
        System.out.println("Podaj kolejną liczbę (lub wpisz \"exit\"): ");
        String input = sc.nextLine();
        if (input.equals(sumNumbers.EXIT))
            return;

        try {
            Double num = Double.parseDouble(input);
            list.add(num);
        } catch (NumberFormatException e) {
            System.err.println("Liczba w niepoprawnym formacie");
        }

        readData(sc, list);
    }

    //metoda do wyświetlania danych
    static void printData(List<Double> list) {
        StringBuilder sb = new StringBuilder();
        double sum = 0;
        for (double d : list) {
            sb.append(d);
            sb.append('+');
            sum += d;
        }
        sb.replace(sb.length() - 1, sb.length(), "=");
        sb.append(sum);
        System.out.println(sb.toString());
    }
}