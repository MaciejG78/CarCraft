package pl.com.bottega.rekrutacja;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by macie on 17.12.2016.
 */
public class TextPhraseApp {

    // ---Rozwiązanie moje

    public static void main(String[] args) {
        String text = "Ala ma kota la la la";
        String phrase = "la";

        TextPhrase textPhrase = new TextPhrase();


     //   textPhrase.checkTextPhrase(text, phrase);

        System.out.println(String.format("Pozycje frazy: %s, dla tekstu: %s to:", phrase, text));
        System.out.println( textPhrase.checkTextPhrase(text, phrase) + "]");
    }



}
