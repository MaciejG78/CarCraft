package pl.com.bottega.rekrutacja;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by macie on 14.01.2017.
 */
public class FileReader {

   public static void main(String[] args) {
       try {
           InputStream inputStream = new FileInputStream("c:\\tmp\\testOutput.txt");
               int c;
               while ((c = inputStream.read()) != -1) {
                   System.out.print((char) c);
               }
               inputStream.close();
       } catch(FileNotFoundException e){
            e.printStackTrace();
       } catch (IOException e) {
            e.printStackTrace();
       }
    }
}
