package pl.com.bottega.javastart.comparable;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by macie on 11.01.2017.
 */
public class NumberComparator {
    public static void main(String[] args) {
        Integer[] numbers = {1, 5, 10, 19, 102, 43, 25, 36, 31,
                99, 9, 77, 7, 66, 6, 55, 44, 33, 1098, 1111};
        System.out.println("Nieposortowana: ");
        System.out.println(Arrays.toString(numbers));

        Arrays.sort(numbers);
        System.out.println("Posortowane rosnąco: ");
        System.out.println(Arrays.toString(numbers));

        Arrays.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -(o1.compareTo(o2));
            }
        });
        System.out.println("Posortowana malejąco: ");
        System.out.println(Arrays.toString(numbers));
    }
}
