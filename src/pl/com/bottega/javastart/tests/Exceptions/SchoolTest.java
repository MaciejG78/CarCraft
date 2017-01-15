package pl.com.bottega.javastart.tests.Exceptions;

/**
 * Created by macie on 06.01.2017.
 */
public class SchoolTest {
    public static void main(String[] args) {
        School school = new School(3);
        try {
            school.add(new Student(1, "Jan", "Kowalski"));
            school.add(new Student(1, "Marek", "Bobowski"));
            school.add(new Student(1, "Karol", "Kwiatkowski"));
            school.add(new Student(1, "Ania", "Marciniak"));
        } catch (NoMoreSpaceException e) {
            System.err.println("Nie można dodać tylu osób do szkoły");
            System.err.println(e.getMessage());
        }

        try {
            System.out.println(school.find("Marek", "Bobowski"));
            System.out.println(school.find("Janusz", "Danielak"));
        } catch (NoElementFoundException e) {
            System.err.println("Nie znaleziono takiej osoby!");
            System.err.println(e.getMessage());
        }
    }
}