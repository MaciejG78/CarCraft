package pl.com.bottega.javastart.tests;

/**
 * Created by macie on 10.01.2017.
 */
public class OddTester {
    public static void main(String[] args) {
        OddTester ot = new OddTester();
        ot.checkNumber(10);
        ot.checkNumber(11);
    }

    public void checkNumber(int n) {
        String check = n%2 == 0? "Parzysta" : "Nieparzysta";
        System.out.println(n + " " + check);
    }
}