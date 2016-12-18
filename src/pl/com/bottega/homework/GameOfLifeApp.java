package pl.com.bottega.homework;

import java.util.Random;

/**
 * Created by macie on 17.11.2016.
 */
public class GameOfLifeApp {
    public static String importantInfo = "Wait and look, next life will be for 1 s";

    public static void main(String[] args) {
        Random random = new Random();
        int countLife = 1;
        int[][] nextTab = new int[5][5];
        for (int i = 0; i < nextTab.length; i++){
            for (int j = 0; j < nextTab[0].length; j++){
                nextTab[i][j] = random.nextInt(2);
            }
        }

        int[][] tab = new int[nextTab.length][nextTab[0].length];
        while(countLife > 0) {
            countLife = 0;
            // for (int cycles = 0; cycles < 30; cycles++) {
            for (int i = 0; i < nextTab.length; i++) {
                for (int j = 0; j < nextTab[i].length; j++) {
                    tab[i][j] = nextTab[i][j];
                }
            }

            printTab(tab);

            for (int i = 0; i < tab.length; i++) {
                for (int j = 0; j < tab[i].length; j++) {
                    if (tab[i][j] == 1 && !(countAround(tab, i, j) == 2 || countAround(tab, i, j) == 3)) {
                        nextTab[i][j] = 0;
                    }
                    else if    (tab[i][j] == 0 && countAround(tab, i, j) == 3) {
                        nextTab[i][j] = 1;
                        countLife++;
                    }
                }
            }

       // }
            try {
                //Message
              System.out.println(importantInfo);
                //Pause for 1 second
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                //Message
              //System.out.println(importantInfo);
            }
        }
        printTab(tab);
    }

    static int countAround(int[][] tablica, int a, int b) {
        int count = 0;
        int[][] arounding = {{a - 1, b - 1},
                {a - 1, b    },
                {a - 1, b + 1},
                {a    , b - 1},
                {a    , b + 1},
                {a + 1, b - 1},
                {a + 1, b    },
                {a + 1, b + 1}};
        for (int i[]: arounding) {
            try {
                if (tablica[i[0]][i[1]] == 1) {
                    count++;
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {}
        }
        return count;
    }

    static void printTab (int[][] tablica) {

        for (int[] i: tablica) {
            for (int j: i) {
                if (j == 1) {
                    System.out.print("O");
                }
                else {
                    System.out.print(".");
                }
            }
            System.out.println();


        }
        System.out.println();

    }

}
