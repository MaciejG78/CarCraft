package pl.com.bottega.javastart.tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by macie on 26.01.2017.
 * W załączniku znajduje się plik z tekstem lorem ipsum. Wczytaj wszystkie słowa osobno do listy słów, a następnie wykorzystując strumienie:
 * <p>
 * usuń wszystkie przecinki i kropki doklejone do słów
 * wyświetl liczbę słów rozpoczynających się literą "s" oraz ile słów składa się z 5 znaków.
 * <p>
 * Podpowiedzi:
 * <p>
 * Napis można podzielić wywołując na nim metodę split(), np: "ala basia, kasa".split(" ")
 * Pierwszy znak Stringa można sprawdzić posługując się metodą charAt(0)
 * Do kolekcji można dodawać całe tablice obiektów przekształcając je wcześniej na listę za pomocą metody Arrays.asList(dowolnaTablica[])
 */
public class KolekcjeStrumienie {
    public static void main(String[] args) throws IOException {
        final String FILE_NAME = "loremipsum.txt";
        BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
        List<String> words = new ArrayList<>();
        String tmp = null;

        while ((tmp = br.readLine()) != null) {
            words.addAll(Arrays.asList(tmp.split(" ")));
        }

        words = words.stream().map(s -> s.replaceAll(",", "").replaceAll("\\.", ""))
                .collect(Collectors.toList());

        long countSWords = words.stream().filter(s -> s.startsWith("s"))
                .peek(s -> System.out.print(s + " ")).count();
        System.out.println();

        long fiveLetters = words.stream().filter(s -> s.length() == 5)
                .peek(s -> System.out.print(s + " ")).count();
        System.out.println();

        System.out.println("Liczba wyrazów na 's': " + countSWords);
        System.out.println("Liczba wyrazów z 5 literami: " + fiveLetters);

        br.close();
    }
}

