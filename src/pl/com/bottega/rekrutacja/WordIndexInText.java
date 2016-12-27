package pl.com.bottega.rekrutacja;

import java.util.*;

/**
 * Created by maciek on 27.12.2016.
 * Indexy poszczególnych słów w wprowadzonym tekście
 */

public class WordIndexInText {

    private static String quitTest = "t";

    public static void main(String[] args) {
        while (!quitTest.equals("q")) {
            Scanner input = new Scanner(System.in);
            System.out.println("Tekst do sprawdzenia: ");
            String textToCheck = input.nextLine();
            System.out.println(indexWords(textToCheck));
            Scanner scanner = new Scanner(System.in);
            System.out.println("Czy chcesz kontynuować z kolejnym tekstem? Jak tak wprowadź dowolny znak, jeśli chcesz wyjść to wprowadź 'q'.");
            quitTest = scanner.nextLine();
        }


//        System.out.println(indexWords("Ala ma kota ala Kota"));
//        System.out.println(indexWords("Ala la la ma kota la ala a baba ma Baba psa"));
    }

    private static Map<String, List<Integer>> indexWords(String text) {
        String textToCheck = " " + text.toLowerCase() + " ";

        String[] splitted = text.toLowerCase().split(" ");
        Map<String, List<Integer>> result = new HashMap<>();


        for (int i = 0; i < splitted.length; i++) {
            if (!result.containsKey(splitted[i])) {
                List<Integer> indexes = new ArrayList<>();
                int lastFound;
                int nextIndexToLook = 0;
                while ((lastFound = textToCheck.indexOf(" " + splitted[i] + " ", nextIndexToLook)) != -1) {
                    indexes.add(lastFound);

                    nextIndexToLook = lastFound + 1;
                }
                result.put(splitted[i], indexes);

            }
        }

        return result;

    }
}