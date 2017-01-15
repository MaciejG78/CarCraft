package pl.com.bottega.rekrutacja;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

/**
 * Created by macie on 14.01.2017.
 */
public class FileWriter {
/* ----Rozwiązanie moje
    public static void main(String[] args) throws FileNotFoundException {
        try {
            OutputStream outputStream = new FileOutputStream("C:\\tmp\\testOutput.txt", false);
            String text = "";
            while (!text.equals("exit")){
                text = readText();
                for (int i = 0; i < text.length(); i++ ) {
                    outputStream.write(text.charAt(i));
                }
            }
            outputStream.close();

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readText() {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        return text;
    }
}

*/

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        try (
                OutputStream os1 = new FileOutputStream("C:\\tmp\\test.txt", true);
                OutputStream os2 = new FileOutputStream("C:\\tmp\\test.txt", true);
        ){ //jeśli w try w () wpiszemy OutputStream lub kilka obiektów i nie trzeba close na końcu - jest Closeable
            while (true) {
                String line = s.nextLine();
                if (line.equals("exit"))
                    break;
                os1.write(line.getBytes());
                os2.write(line.getBytes());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {

        }
    }
}

