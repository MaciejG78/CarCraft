package pl.com.bottega.javastart.hospital;

/**
 * Created by macie on 06.01.2017.
 */
public class Person {

    private String firstName;
    private String lastName;
    private double salary;
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Person(String firstName, String lastName, double salary) {
        setFirstName(firstName);
        setLastName(lastName);
        setSalary(salary);
    }

    @Override
    public String toString() {
        return "Imię: " + firstName + ", Nazwisko: " + lastName + ", Wypłata " + salary;
    }
}
