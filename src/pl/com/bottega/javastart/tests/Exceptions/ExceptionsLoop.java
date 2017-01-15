package pl.com.bottega.javastart.tests.Exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Created by macie on 06.01.2017.
 */
public class ExceptionsLoop {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj liczbę: ");
        int number = 0;
        boolean error = true;
        while(error) {
            try {
                number = sc.nextInt();
                error = false;
            } catch(InputMismatchException e) {
                System.out.println("Nie podałeś liczby całkowitej, spróbuj jeszcze raz: ");
                sc.nextLine();
            }
        }
        System.out.println("Podałeś: " + number);
        sc.close();
    }
}
