package pl.com.bottega.rekrutacja;

import java.util.Scanner;

/**
 * Created by maciek on 08.01.2017.
 * Napisac funkcje ktora dla zadanej liczby nieujemnej zwraca `true` jesli liczba ta jest palindromem,
 * w przeciwnym razie `false`. Liczba jest palindromem jesli jej cyfry zapisane w odwrotnej kolejnosci
 * daja te sama liczbe, np.  101, 2552, 99499
 */
public class Palindroms {

    private static String quitTest = "t";

    public static void main(String[] args) {
        readPalindromsAndCheck();
    }

    private static void readPalindromsAndCheck() {
        System.out.println("Wprowadź liczbę do sprawdzenia lub wpisz 'q' aby zakończyć:");
        String text = readNumber();
        while (!text.equals("q")){
            System.out.println(isPalindrome(text));
            text = readNumber();
        }
        System.out.println("Koniec programu.");
    }

    private static String readNumber() {
        Scanner scanner = new Scanner(System.in);
        String numberToCheck = scanner.nextLine();
        return numberToCheck;
    }

    private static boolean isPalindrome(String numberToCheck){
        String palindrom = "";
        for (int i = numberToCheck.length() - 1; i >= 0; i--){
            palindrom += numberToCheck.charAt(i);
        }
        return numberToCheck.equals(palindrom);
    }


    //Rozwiązania Maćka - matematyczne
    private static boolean isPalindrom(int n){
        int reverted = 0;
        int tmp = n;
        while (n > 0) {
            reverted = reverted * 10 + n % 10;
            n /= 10;
        }
        return reverted == tmp;
    }

    //Rozwiązanie Maćka na Stringach
    private static boolean isPalindroms(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }

}