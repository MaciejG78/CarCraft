package pl.com.bottega.rekrutacja;

import com.sun.deploy.util.StringUtils;

/**
 * Created by macie on 07.01.2017.
 * Napisać funkcję która dla zadanej liczby nieujemnej `n` printuje na konsoli choinkę złożoną z `n` wierszy
 *   #
 *  ###
 * #####
 * dla n = 3
 */
public class ChristmasTree {

    //Rozwiązanie wzorcowe Maćka
    public static void main(String[] args) {
        printChristmasTree(9);
    }

    public static void printChristmasTree(int n){
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

}


    /*
    //Moje rozwiązanie działa, ale jest złe bo za każdym razem skleja stringa i to jest pamięciożerne, trzeba by przerobić
    //żeby nie sklejał ale w pętli od razu printował na ekran

    public int rows;

    public static void main(String[] args) {
        paintTree(10);
    }


    public static void paintTree(int rows){
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
*/