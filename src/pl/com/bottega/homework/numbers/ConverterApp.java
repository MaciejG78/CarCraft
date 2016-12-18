package pl.com.bottega.homework.numbers;

/**
 * Created by Maciej G. on 03.12.2016.
 * Konwersja liczby do postaci słownej, czyli:
 * wejście: 25 wynik: dwa pięć
 * oraz konwersja doubla do takiej samej postaci słownej, czyli:
 * wejście: 12,43 wyjście: jeden dwa przecinek cztery trzy
 */
public class ConverterApp {
    public static final String DICTIONARY = "US"; //Wskazanie na słownik

  public static void main(String[] args) {

        long userInput = read();
        String result = AlmightyStringUtils.convert(userInput);
        display(result);

        double userInput2 = readDouble();
        result = AlmightyStringUtils.convert(userInput2);
        display(result);
    }

//Wyświetlenie wyniku
    private static void display(String result) {
        System.out.println("|" + result + "|");
    }

//Wczytanie warości do zamiany na słowa
    private static long read(){
        return 25000;
    }

//Zamiana doubla na słowny (ta wartość z dołu czyli 25000 /20/8)
    private static double readDouble(){
        return read() / 20 / 8;
    }

    static String dict(){
        return DICTIONARY;
    }
}
