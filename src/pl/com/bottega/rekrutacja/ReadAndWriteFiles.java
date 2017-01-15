package pl.com.bottega.rekrutacja;

import java.io.*;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by macie on 15.01.2017.
 * Napisac program ktory przyjmuje 2 parametry linii polecen: sciezke do tekstowego pliku wejsciowego i do pliku wynikowego.
 * Program czyta plik wejsciowy i zapisuje do pliku wyjsciowego wszystkie slowa ktore wystepuja w pliku wejsciowym
 * wraz z iloscia ich wystapien (kazde slowo w nowej linii).
 */
public class ReadAndWriteFiles {

    public static void main(String[] args) {

        Map<String, Integer> words = new HashMap<>();

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(args[0]));
            PrintWriter printWriter = new PrintWriter(args[1]);
            String textLine = null;
            while ((textLine = reader.readLine()) != null) {
                String[] splitted = textLine.toLowerCase().split("\\s{1,}");

                for (String st : splitted) {
                    Integer readerKey = words.get(st);
                    if (readerKey == null) {
                        words.put(st, 1);
                    } else {
                        words.put(st, readerKey + 1);
                    }
                }

            }
            for (String st : words.keySet()) {
                printWriter.println(st + " " + words.get(st));
            }
                reader.close();
                printWriter.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
