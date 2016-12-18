package pl.com.bottega.rekrutacja;

/**
 * Created by maciek on 10.12.2016.
 * Wyświetlić pierwszych 15 liczb które mają w reprezentacji binarnej same jedynki
 */
public class BinaryOnes {
    public static void main(String[] args) {
        long number = 1;
        for (int i = 1; i <= 15; i++) {
            number *= 2; //nieoptymalnie jest wiele cykli potęgowania i praca jest na doublach a następnie jest rzutowanie na int lub long: (long) (Math.pow(2, i) - 1);
            System.out.println(number - 1);
        }

        System.out.println("----------- Drugi sposób ----------------");
        long pow = 1;
        long number2 = 1;
        for (int i = 1; i <= 15; i++) {
            System.out.println(number2);
            pow = pow << 1;//Przesunięcie w kodzie o 1 w lewo czyli z 1 powstaje 10 (2) i następnie 100 (4) itd. w binarnym zapisie
            number2 = number2 | pow; //można zapisać: number2 = number2 + pow; ale jest też operator bitowego dodawania, jest to szybsze: number2 = number2 | pow;
        }

    }
}
