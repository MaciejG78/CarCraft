package pl.com.bottega.rekrutacja;

import java.util.Scanner;

/**
 * Created by macie on 18.01.2017.
 */
public class ChritmasTreev3 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        int t = num;

        for (int k = 0; k <= num; ++k) {
            for (int j = t - 1; j >= 0; --j) System.out.print(" ");
            for (int i = 0; i < (k * 2 - 1); ++i) System.out.print("*");
            System.out.println();
            t = t - 1;
        }
    }

}
