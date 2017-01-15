package pl.com.bottega.javastart.tests.Exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by macie on 06.01.2017.
 */
public class ExceptionsArray {

 public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numbers[] = new int[2];
        boolean error = true;

        while(error) {
            try {
                System.out.println("Podaj 1 liczbę: ");
                numbers[0] = sc.nextInt();
                sc.nextLine();
                System.out.println("Podaj 2 liczbę: ");
                numbers[1] = sc.nextInt();
                sc.nextLine();

                System.out.println("Którą wartość wyświetlić (1 lub 2)? ");
                System.out.println(numbers[sc.nextInt() - 1]);
                error = false;
            } catch(InputMismatchException ex) {
                System.out.println("Nie podałeś liczby całkowitej, spróbuj jeszcze raz: ");
                sc.nextLine();
            } catch(ArrayIndexOutOfBoundsException ex) {
                System.out.println("Miało być 1 lub 2, zacznijmy od nowa: ");
                sc.nextLine();
            }
        }
        sc.close();
    }
}

