package pl.com.bottega.rekrutacja;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Maciek Zubala on 15.01.2017.
 * mzubala [9:26 AM]
 Napisac program ktory przyjmuje 2 parametry linii polecen: sciezke do tekstowego pliku wejsciowego i do pliku wynikowego.
 Program czyta plik wejsciowy i zapisuje do pliku wyjsciowego wszystkie slowa ktore wystepuja w pliku wejsciowym wraz
 z iloscia ich wystapien (kazde slowo w nowej linii).
 */
public class ReadAndWriteFilesWzor {

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("Wrong number of parameters");
            return;
        }
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
                PrintWriter pw = new PrintWriter(args[1])
        ) {
            Map<String, Integer> counter = countWords(br);
            printCounter(counter, pw);
        }
    }

    private static void printCounter(Map<String, Integer> counter, PrintWriter pw) {
        for(Map.Entry<String, Integer> entry : counter.entrySet()) {
            pw.println(entry.getKey() + " " + entry.getValue());
        }
    }

    private static Map<String, Integer> countWords(BufferedReader br) throws IOException {
        String line;
        Map<String, Integer> counter = new HashMap<>();
        while((line = br.readLine()) != null) {
            line = line.trim().toLowerCase();
            String[] words = line.split(" ");
            for(String word : words) {
                if(word.length() == 0)
                    continue;
                Integer count = counter.getOrDefault(word, 0);
                count += 1;
                counter.put(word, count);
            }
        }
        return counter;
    }

}