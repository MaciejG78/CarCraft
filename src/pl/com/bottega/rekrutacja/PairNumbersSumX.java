package pl.com.bottega.rekrutacja;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by macie on 11.12.2016.
 * Funkcja która dla zadanej tablicy liczb całkowitych dodatnich i pewnej całkowitej licznby x
 * zwróci zbiór unikalnych par liczb z tablicy które w sumie dają x.
 */
public class PairNumbersSumX {

//--------------------- Rozwiązanie właściwe ----------------------------------
  public static Set<Pair> findPairs(int[] numbers, int sum) {
      Set<Pair> pairs = new HashSet<Pair>();
      for (int i = 0; i < numbers.length -1; i++){
          int current = numbers[i]; //dobrze jest ustawić zmienną bo dostęp do
          for (int j = i + 1; j < numbers.length; j++){
              if (current + numbers[j] == sum)
                  pairs.add(new Pair(current, numbers[j]));

          }
      }
        return pairs;
  }

    public static void main(String[] args) {
        System.out.println(findPairs(new int[]{3, 4, 5, 6, 7, 8, 9, 4, 3, 2, 5, 6, 2, 1}, 7));
    }


}
