package pl.com.bottega.javastart.tests.Files;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by macie on 10.01.2017.
 */
public class ObjectWriter {

    public static void main(String[] args) {
        String fileName = "person.obj";
        Person p1 = new Person("Jan", "Kowalski");
        Person p2 = new Person("Piotr", "Nowak");
        Person p3 = new Person("Anna", "Januszko");

        try(
                FileOutputStream fs = new FileOutputStream(fileName);
                ObjectOutputStream os = new ObjectOutputStream(fs);
        ) {
            os.writeObject(p1);
            os.writeObject(p2);
            os.writeObject(p3);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Zapisano obiekt do pliku");
    }
}

