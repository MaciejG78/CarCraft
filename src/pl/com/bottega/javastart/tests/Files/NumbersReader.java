package pl.com.bottega.javastart.tests.Files;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

/**
 * Created by macie on 11.01.2017.
 */
public class NumbersReader {

 public static void main(String[] args) {
        String fileName = "numbers.txt";
        int a=0, b=0, c = 0;
        BigInteger aBig = null, bBig = null;

        try(
                FileReader fr = new FileReader(fileName);
                BufferedReader br = new BufferedReader(fr);
        ) {

            a = Integer.parseInt(br.readLine());
            b = Integer.parseInt(br.readLine());
            c = Integer.parseInt(br.readLine());
            aBig = new BigInteger(br.readLine());
            bBig = new BigInteger(br.readLine());

        } catch (FileNotFoundException e) {
            System.err.println("Nie znaleziono pliku");
        } catch (IOException e) {
            System.err.println("Błąd odczytu danych");
        }

        System.out.println("a+b+c = " + (a+b+c));
        System.out.println("aBig+bBig = " + aBig.add(bBig));
    }
}