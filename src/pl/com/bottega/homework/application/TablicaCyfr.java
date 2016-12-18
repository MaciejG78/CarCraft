package pl.com.bottega.homework.application;

/**
 * Created by macie on 06.11.2016.
 */
public class TablicaCyfr {
    public static void main(String[] args){
        int [] data = new int[40];
        //wypełnienie danymi
        for (int i = 0; i < data.length; i++){
            data[i] = i + 1;
        }
        //suma elementów
        long sum = 0;
        for (int i = 0; i < data.length; i++){
            sum += data[i];
        }
        System.out.println(sum);

        //Pętla while
        sum = 0;
        int i = 0;
        while(i < data.length){
            sum += data[i];
            i++;
        }
        System.out.println(sum);

        /*
        //Pętla do while
        do{


        }while(...);
        */
    }

}
