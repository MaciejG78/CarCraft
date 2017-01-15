package pl.com.bottega.javastart.tests.Files;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by macie on 10.01.2017.
 */
public class ObjectReader {
    public static void main(String[] args) {
        String fileName = "person.obj";

        Person p1 = null;
        Person p2 = null;
        Person p3 = null;

        try(
                FileInputStream fis = new FileInputStream(fileName);
                ObjectInputStream ois = new ObjectInputStream(fis);
        ) {

            p1 = (Person) ois.readObject();
            p2 = (Person) ois.readObject();
            p3 = (Person) ois.readObject();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if(p1 != null && p2 != null && p3 != null) {
            System.out.println("Wczytano dane o: ");
            System.out.println(p1.getFirstName() + " " + p1.getLastName());
            System.out.println(p2.getFirstName() + " " + p2.getLastName());
            System.out.println(p3.getFirstName() + " " + p3.getLastName());
        }
    }
}
