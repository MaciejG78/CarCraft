package pl.com.bottega.rekrutacja;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by macie on 11.12.2016.
 * Funkcja która dla zadanej tablicy liczb całkowitych dodatnich i pewnej całkowitej licznby x
 * zwróci zbiór unikalnych par liczb z tablicy które w sumie dają x.
 */
public class PairNumbersSumXMy {

  public static int[] numbers = {3, 4, 5, 6, 7, 8, 9, 4, 3, 2, 5, 6, 2, 1};
    public static int x = 7;
    public static Set<Pair> pairs = new HashSet<>();

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 1; j < numbers.length; j++){
                sum = numbers[i]+numbers[j];

                if (sum == x) {
                    String first = String.valueOf(numbers[i]);
                    String second = String.valueOf(numbers[j]);

                    if (pairs.contains(numbers[j] + ", " + numbers[i])) //powinno porownywać i jeśli występuje to nie powiino dodawać do Ste-a
                    continue;
                    pairs.add(new Pair(first, second));
                }
            }
        }
        for(Pair pair : pairs) {
            System.out.println(pair.getFirst() + ", " + pair.getSecond());
        }

//        System.out.printf("(%s, %s) %n", first, second);

    }

    public static class Pair {
        String first, second;
        Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int hashCode() {
            return first.hashCode();
        }

        @Override
        public boolean equals(Object other) {
            if (other == this) {
                return true;
            }
            if (!(other instanceof Pair)) {
                return false;
            }

            Pair otherPair = (Pair) other;
            return (first.equals(otherPair.first) && second.equals(otherPair.second))
                    || (first.equals(otherPair.second) && second.equals(otherPair.first));
        }

        public String getFirst() {
            return first;
        }

        public String getSecond() {
            return second;
        }

    }
}
