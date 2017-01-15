package pl.com.bottega.rekrutacja;

/**
 * Created by macie on 07.01.2017.
 */
public class ChristmasTreeMy {


    public static void main(String[] args) {
        long time1, time2, time3;

        long startTime = System.nanoTime();
        paintTree(100);
        time1 = System.nanoTime()-startTime;
        startTime = System.nanoTime();
        paintTree2(100);
        time2 = System.nanoTime()-startTime;
        startTime = System.nanoTime();
        paintTree3(100);
        time3 = System.nanoTime()-startTime;
        System.out.println("Time1: " + time1);
        System.out.println("Time2: " + time2);
        System.out.println("Time3: " + time3);
    }

//Rozwiązanie moje po poprawkach - printowanie znaków bezpośrednio na konsolę
    public static void paintTree(int rows){
        int numberX = 1;
        int numberSpace = rows - 1;
        for (int i = 0; i < rows; i++ ) {
            for (int j = numberSpace; j > 0; j--) {
                System.out.print(" ");
            }
            for (int j = numberX; j > 0; j--) {
                System.out.print("X");
            }
            for (int j = numberSpace; j > 0; j--){
                System.out.print(" ");
            }
            numberSpace--;
            numberX += 2;
            System.out.println();
        }

    }

    //Rozwiązanie wzorcowe Maćka
    public static void paintTree2(int n){
        int spaces = n - 1;
        int hashes = 1;
        for(int i = 1; i <= n; i++, spaces -= 1, hashes +=2){
            printChars(spaces, ' ');
            printChars(hashes, '#');
            System.out.println();
        }
    }

    private static void printChars(int count, char c){
        for (int i = 1; i <= count; i++)
            System.out.print(c);
    }

    //Rozwiązanie moje wersja 1.
    public static void paintTree3(int rows){
        int numberX = 1;
        int numberSpace = rows - 1;
        for (int i = 0; i < rows; i++ ){
            String row = repeat(" ", numberSpace) + repeat("x", numberX) + repeat(" ", numberSpace);
            System.out.println(row);
            numberSpace -= 1;
            numberX += 2;
        }


    }
    public static String repeat(String s, int times) {
        if (times <= 0) return "";
        else return s + repeat(s, times-1);
    }
}