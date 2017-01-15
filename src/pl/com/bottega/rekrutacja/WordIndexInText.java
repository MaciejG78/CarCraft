package pl.com.bottega.rekrutacja;

import java.util.*;

/**
 * Created by maciek on 27.12.2016.
 * Indexy poszczególnych słów w wprowadzonym tekście
 */

public class WordIndexInText {

    private static String quitTest = "t";

    public static void main(String[] args) {


        System.out.println(indexWords("Ala ma kota ala Kota"));
        System.out.println(indexWords("Ala la la ma kota la ala a baba ma Baba psa"));
        System.out.println(indexWords("        "));
        System.out.println(indexWords("Ala ma kota la alalala"));
        System.out.println(indexWords("    Ala ma kota la alalala"));
        System.out.println(indexWords("The Phantom of the Opera is there inside your mind"));

       // readTextAndFindIndexes();

    }

    private static void readTextAndFindIndexes() {
        System.out.println("Wprowadź tekst do sprawdzenia lub wpisz 'q' aby zakończyć:");
        String text = readText();
        while (!text.equals("q")) {
            System.out.println(indexWords(text));
            text = readText();
        }
        System.out.println("Koniec programu.");
    }

    private static String readText() {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        return text;
    }

    private static Map<String, List<Integer>> indexWords(String text) {

        /* Rozwiązanie Piotrka Rojka Przy jednorazaowym przebiegu sprawdza pokolei słowa i dodaje do mapy

        String textToCheck = text.toLowerCase();

        String[] splitted = text.toLowerCase().split(" ");
        Map<String, List<Integer>> result = new HashMap<>();
        int indexToLook = 0;

        for (int i = 0; i < splitted.length; i++) {
            if (!result.containsKey(splitted[i])) {
                result.put(splitted[i], new ArrayList<>());
            }

            result.get(splitted[i]).add(textToCheck.indexOf(splitted[i], indexToLook));
            indexToLook = indexToLook + splitted[i].length() + 1;
        }
             return result;
        }
    }

    */// /* Moje rozwiązanie - każde słowo wyszukuje w tekście i dodaje do listy, następnie wrzuca wynik do mapy
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

                        nextIndexToLook = lastFound + splitted[i].length() + 1;
                    }
                    result.put(splitted[i], indexes);

                }
            }


        return result;
    }
}