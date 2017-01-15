package pl.com.bottega.javastart.tests.Files;

import java.io.*;

/**
 * Created by macie on 10.01.2017.
 */
public class FileTester {
    public static void main(String[] args) {
        String fileName = "testFile.txt";
        readFile(fileName);

        //Konstrukcja try-with-resources (deklaracja i inicjalizacja obektów w nawiasach zwykłych (), nie trzeba wywoływać close()
        //Wykona się samo po wykonaniu kodu z bloku try.
        try (
                //Przy tworzeniu pliku BufferedWriter warto zauważyć, że wywołaliśmy wersję konstruktora FileWriter z opcjonalnym parametrem true.
                // Bez tego parametru plik zostałby nadpisany, w przypadku, gdy ustawimy wartość tego argumentu na true, to na końcu zostaną dopisane nowe rzeczy.
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        ) {
            writer.newLine();
            writer.write("Wiersz 6 - Bartek");
            writer.newLine();
            writer.write("Wiersz 7 - Wojtek");
        } catch(IOException e) {
            System.err.println("Błąd zapisu do pliku");
        }

        System.out.println("----------------------------");
        System.out.println("Plik wynikowy ma postać:");
        readFile(fileName);
    }

    private static void readFile(String fileName) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String tmp = null;
            while ((tmp = reader.readLine()) != null) {
                System.out.println(tmp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}