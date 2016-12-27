package pl.com.bottega.rekrutacja;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by macie on 27.12.2016.
 */
public class CountWordInText {

         public static void main(String[] args) {
            System.out.println(wordsToCheck("Ala ma kota ala Kota"));
            System.out.println(wordsToCheck("Ala la la ma kota la ala a baba ma Baba psa"));
        }

        private static Map<String, Integer> wordsToCheck(String text) {
            String[] splitted = text.toLowerCase().split(" ");
            Map<String, Integer> result = new HashMap<>();

            for (int i = 0; i < splitted.length; i++) {
                if (result.containsKey(splitted[i])) {
                    int cont = result.get(splitted[i]);
                    result.put(splitted[i], cont + 1);
                } else {
                    result.put(splitted[i], 1);
                }
            }
            return result;
        }
    }
