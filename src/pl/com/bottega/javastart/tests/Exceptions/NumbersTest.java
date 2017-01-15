package pl.com.bottega.javastart.tests.Exceptions;

/**
 * Created by macie on 06.01.2017.
 */
public class NumbersTest {
    public static void main(String[] args) {
        Numbers nums = new Numbers();
        try {
            // wszystko ok
            nums.add(3, 5);
            // błędy indeks, wygenerowanie wyjątku
            nums.add(20, 20);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
