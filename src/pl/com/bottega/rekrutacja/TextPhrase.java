package pl.com.bottega.rekrutacja;

/**
 * Created by macie on 17.12.2016.
 * Napisać funkcję która dla zadanych dwóch parametrów typu `String`, `text` oraz `phrase` zwraca zbiór wszystkich indeksów pod którym `phrase` występuje w `text`.
 */
public class TextPhrase {


// ---Rozwiązanie moje

    public String checkTextPhrase(String text, String phrase) {
        String textToCheck;
        int textLenght = text.length();
        int phaseLenght = phrase.length();
        String value = "[ ";
        for (int i = 0; i <= (textLenght - phaseLenght); i++) {
            textToCheck = text.substring(i, i + phaseLenght);

            if (textToCheck.equals(phrase)) {
                value += i + " ";
            }
        }
        return value;
    }
}

