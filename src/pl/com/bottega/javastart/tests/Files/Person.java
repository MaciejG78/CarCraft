package pl.com.bottega.javastart.tests.Files;

import java.io.Serializable;

/**
 * Created by macie on 10.01.2017.
 */
public class Person implements Serializable{


    private static final long serialVersionUID = 3812017177088226528L;

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

    public Person(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

}

