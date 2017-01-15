package pl.com.bottega.javastart.tests.Exceptions;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by macie on 06.01.2017.
 */
public class Exceptions {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj liczbę: ");
        int number = 0;
        try {
            number = sc.nextInt();
        } catch(InputMismatchException ex) {
            System.err.println("Podana wartość nie jest liczbą całkowitą");
            ex.printStackTrace();
        }
        System.out.println("Podałeś: " + number);
        sc.close();
    }
}

