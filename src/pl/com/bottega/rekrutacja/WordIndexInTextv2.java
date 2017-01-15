package pl.com.bottega.rekrutacja;

import java.util.*;

/**
 * Created by maciek on 27.12.2016.
 * Indexy poszczególnych słów w wprowadzonym tekście
 */

public class WordIndexInTextv2 {
    public static void main(String[] args) {

        readTextAndPrintWords();

    }

    private static void readTextAndPrintWords() {
        System.out.println("Enter text or type \"end\" to quit.");
        String text = readText();
        while (!text.equals("end")) {
            indexWords(text);
            printMap(indexWords(text));
            text = readText();
        }
        System.out.println("End of program.");
    }

    private static String readText() {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        return text;
    }


    private static Map<String, List<Integer>> indexWords(String text) {
        Map<String, List<Integer>> map = new LinkedHashMap<>();

        text = text.toLowerCase();
        text = text.replaceAll("\\s+", " ");
        String[] splittedText = text.split(" ");
        int count = 0;

        for (int i = 0; i < splittedText.length; i++) {
            if (!map.containsKey(splittedText[i])) {
                map.put(splittedText[i], new LinkedList<>());
            }
            map.get(splittedText[i]).add(text.indexOf(splittedText[i], count));
            count = count + splittedText[i].length() + 1;
        }

        return map;
    }

    private static void printMap(Map<String, List<Integer>> map) {
        for (String str : map.keySet()) {
            String key = str.toString();
            String value = map.get(str).toString();
            System.out.println(key + " " + value);
        }
    }
}
