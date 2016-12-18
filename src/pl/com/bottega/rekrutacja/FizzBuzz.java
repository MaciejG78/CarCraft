package pl.com.bottega.rekrutacja;

/**
 * Created by macie on 10.12.2016.
 * Wyświetlenie ciągu liczb od 1 do 200 jeśli jest liczba podzielna przez 3 to wyświetlamy FIZZ, jeśli przez 5 to BUZZ
 * jeśli przez 3 i 5 to FIZZ BUZZ, w pozostałych przypadkach wyświetla liczby
 */
public class FizzBuzz {

    public static void main(String[] args) {

        for (int i = 1; i <= 200; i++) {
            if (i % 3 == 0 && i % 5 == 0) //Można to zapisać też jako: if (i % 15 == 0) {
                System.out.println("FIZZ BUZZ");
            else if (i % 3 == 0)
                System.out.println("FIZZ");
            else if (i % 5 == 0)
                System.out.println("BUZZ");
            else
                System.out.println(i);
        }
    }
}