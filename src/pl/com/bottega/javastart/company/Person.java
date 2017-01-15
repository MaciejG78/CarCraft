package pl.com.bottega.javastart.company;

import java.io.Serializable;

/**
 * Created by macie on 10.01.2017.
 */
public class Person implements Serializable {
    private static final long serialVersionUID = 3812017177088226529L;

    private String firstName;
    private String lastName;

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

    public Person(){}

    public Person(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}