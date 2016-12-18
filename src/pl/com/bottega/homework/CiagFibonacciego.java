package pl.com.bottega.homework;

/**
 * Created by macie on 08.11.2016.
 */

public class CiagFibonacciego {
    //Metoda prywatna statyczna
    public static void main(String[] aparams) {
        int count = readCount();
        
        int[] elements = new int[count];
        
        fill(elements);
        
        display(elements);

        
    }

    private static void fill(int[] elements) {
        elements[0] = 0;
        if(elements.length == 1)
            return;
        elements[1] = 1;
        for(int i = 2; i < elements.length; i++){
            elements[i] = elements[i-1]+elements[i-2];
        }
    }

    private static void display(int[] data) {

        //Pętla for (automatyczna) służy tylko do odczytywania danych
        for(int element : data){
            System.out.print(element + " ");

        }
    }

    private static int readCount() {
        return 100;
    }
}


/* moje rozwiązanie
        public static void main(String[] args) {
            int[] tablica = new int[20];

            for (int i = 0; i < tablica.length; i++){
                if (i == 0)
                tablica[i] = 0;
                else
                    if (i == 1)
                        tablica[i]=1;
                        else
                            tablica[i] = tablica[i-2] + tablica[i-1];
                System.out.print(tablica[i] + ", ");
            }
        System.out.println("Koniec ciągu Fibonacciego");
        }

}


*/


