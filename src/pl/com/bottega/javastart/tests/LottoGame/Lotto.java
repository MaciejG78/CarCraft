package pl.com.bottega.javastart.tests.LottoGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by macie on 26.01.2017.
 */
public class Lotto {
    private List<Integer> numbers;

    public Lotto() {
        numbers = new ArrayList<>();
        generate();
    }

    private void generate() {
        for (int i = 1; i <= 49; i++) {
            numbers.add(i);
        }
    }

    public void randomize() {
        Collections.shuffle(numbers);
    }

    public int checkResult(List<Integer> userNumbers) {
        List<Integer> lottoResult = numbers.subList(0, 6);

        System.out.println("Wynik losowania: ");
        for (Integer num : lottoResult) {
            System.out.print(num + " ");
        }
        System.out.println();

        int found = 0;
        for (int i = 0; i < 6; i++) {
            if (lottoResult.contains(userNumbers.get(i))) {
                found++;
            }
        }
        return found;
    }
}