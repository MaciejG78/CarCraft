package pl.com.bottega.rekrutacja;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


//Rozwiązanie optymalne Krzyśka

public class WordsInText {
    public static void main(String[] args) {
        System.out.println(wordsInText("Ala ma kota ala"));
        System.out.println(wordsInText("Ala"));
        System.out.println(wordsInText("        "));
        System.out.println(wordsInText("Ala ma kota la alalala"));
        System.out.println(wordsInText("    Ala ma kota la alalala"));
        System.out.println(wordsInText("The Phantom of the Opera is there inside your mind"));
        System.out.println(wordsInText("Remember, remember the fifth of November, the gunpowder treason and plot." +
                " I know of no reason why the gunpowder treason should ever be forgot."));

    }

    private static Map<String, List<Integer>> wordsInText(String s) {
        s = s.concat(" ").toLowerCase(); //dodaliśmy spację na końcu, żeby wyszukać ostatnie słowo

        Map<String, List<Integer>> result = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        String word;
        int i = 0;

        for (char c : s.toCharArray()) { //sprawdzamy literka po literce
            if (c == ' ') {
                if (stringBuilder.length() != 0) {
                    word = stringBuilder.toString();
                    stringBuilder = new StringBuilder();
                    if (!result.containsKey(word))
                        result.put(word, new LinkedList<>());
                    List<Integer> indexes = result.get(word);
                    indexes.add(i - word.length());

                }
            } else
                stringBuilder.append(c);
            i++;
        }
        return result;
    }

}
