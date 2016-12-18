package pl.com.bottega.rekrutacja;

import java.util.*;

/**
 * Created by macie on 17.12.2016.
 */
//Rozwiązanie wzorcowe Maćka wszystko w jednej klasie

public class RhraseFinder {

    public static void main(String[] args) {
        System.out.println(findPhrase("Ala ma la la kota la la la", "la"));
        System.out.println(findPhrase("aaaaaaaaaaa", "a"));
    }

/*
    public static Set<Integer> findPhrase(String text, String phrase) {
        Set<Integer> result = new TreeSet<>();
        int lastFound;
        int nextIndexToLook = 0;
        while ((lastFound = text.indexOf(phrase, nextIndexToLook)) != -1) {
            result.add(lastFound);
            nextIndexToLook = lastFound + 1;
        }
        return result;
    }
}
*/
//Rozwiązanie moje z indexOf
        public static Set<Integer> findPhrase(String text, String phrase) {
        Set<Integer> result = new TreeSet<>();
        int textLenght = text.length();
        int phraseLenght = phrase.length();
        for (int i = 0; i <= textLenght; i++) {
            int indexOfValue =  text.indexOf(phrase, i);
            if (indexOfValue != -1) {
                result.add(indexOfValue);
                i = indexOfValue;
            }
        }
//Rozwiązanie z sortowniem przy pomocy listy, trzeba zmienić początek na: public static List findPhrase
//        List sortedList = new ArrayList(result);
//        Collections.sort(sortedList);
//          return sortedList;
        return result;
    }
}




/* ----wersja z dwoma pętlami
    public static Set<Integer> findPhrase(String text, String phrase){
        Set<Integer> result = new HashSet<>();
        int textLenght = text.length();
        int phraseLenght = phrase.length();
        for (int i = 0; i <= textLenght - phraseLenght; i++) {
            boolean mismatch = false;
            for (int j = 0; j < phraseLenght && !mismatch; j++)
                if (text.charAt(i + j) != phrase.charAt(j))
                    mismatch = true;
            if (!mismatch)
                result.add(i);
        }
        return result;
    }
}
*/
