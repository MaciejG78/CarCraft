package pl.com.bottega.javastart.hospital;

/**
 * Created by macie on 06.01.2017.
 */
public class Hospital {
    public static final int MAX_EMPLOYEES = 3;

    private Person[] employees;
    private int employeesNumber;

    public Person[] getEmployees() {
        return employees;
    }

    public void setEmployees(Person[] employees) {
        this.employees = employees;
    }

    public int getEmployeesNumber() {
        return employeesNumber;
    }

    public void setEmployeesNumber(int employeesNumber) {
        this.employeesNumber = employeesNumber;
    }

    public Hospital() {
        setEmployees(new Person[MAX_EMPLOYEES]);
        setEmployeesNumber(0);
    }

    public void add(Person person) {
        if(getEmployeesNumber() < MAX_EMPLOYEES) {
            getEmployees()[getEmployeesNumber()] = person;
            setEmployeesNumber(getEmployeesNumber() + 1);
        }
    }

    @Override
    public String toString() {
        String result = "";
        for(int i=0; i<employeesNumber; i++) {
            result = result + employees[i] + "\n";
        }
        return result;
    }
}
