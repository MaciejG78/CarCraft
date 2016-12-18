package pl.com.bottega.homework;

/**
 * Created by macie on 08.11.2016.
 */

public class TabliczkaMnozenia {


        public static void main(String[] args) {
            int[][] tablica = new int[10][10];

            for (int i = 0; i < tablica.length; i++) {
                for (int j = 0; j < tablica[i].length; j++) {
                    if (i == 0 && j == 0)
                        tablica[i][j] = 0;
                    else if (i == 0)
                        tablica[i][j] = j;
                    else if (j == 0)
                        tablica[i][j] = i;
                    else
                        tablica[i][j] = i * j;
                    if (tablica[i][j] < 10)
                    System.out.print("  " + tablica[i][j] + "  |");
                        else
                        System.out.print(" " + tablica[i][j] + "  |");

                }
                System.out.println(" ");
                System.out.println("------------------------------------------------------------");
            }
        }

}



