package pl.com.bottega.javastart.company;

import java.io.Serializable;

/**
 * Created by macie on 10.01.2017.
 */
public class Company implements Serializable {
    private static final long serialVersionUID = -7425273230264572679L;
    public static final int EMPLOYEES = 3;
    private Employee[] employees;

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    public Company() {
        employees = new Employee[EMPLOYEES];
    }

    public void add(Employee emp, int index) {
        employees[index] = emp;
    }
}