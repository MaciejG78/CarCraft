package pl.com.bottega.rekrutacja;

/**
 * Created by macie on 12.12.2016.
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 *
 *Jeśli lista wszystkich liczb naturalnych, które są poniżej 10 wielokrotnością 3 lub 5, otrzymamy 3, 5, 6 i 9. Suma tych wielokrotności wynosi 23.
 *  Znajdź sumę wszystkich wielokrotności 3 lub 5 poniżej 1000.
 */
public class Multiply3and5Sum {


    public static void main(String[] args) {

        int sum = 0;
        int number = 0;
        for (int i = 1; i < 1000; i++){

            if (i % 3 == 0 || i % 5 == 0) {
                //number = i;
                sum += i;
                System.out.println(i);
            }
        }
            System.out.println("Sum this numbers is: " + sum);

    }
}
