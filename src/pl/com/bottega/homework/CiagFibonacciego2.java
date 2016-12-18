package pl.com.bottega.homework;

/**
 * Created by macie on 12.11.2016.
 */
public class CiagFibonacciego2 {
    public static void main (String[] args){
        int no = readNumber();

        int previous = 1;
        int prePrevious = 0;



        for (int i = 2; i < no; i++){
            int current = prePrevious + previous;
            prePrevious = previous;
            previous = current;

        }
        if (no == 0)
            System.out.println("0");
        else
            System.out.println(previous);
    }

        private static int readNumber() {
        return 0;
    }
}
