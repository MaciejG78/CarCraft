package pl.com.bottega.javastart.hospital;

/**
 * Created by macie on 06.01.2017.
 */
public class Doctor extends Person{

    private double bonus;

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public Doctor(String firstName, String lastName, double salary, double bonus) {
        super(firstName, lastName, salary);
        setBonus(bonus);
    }

    @Override
    public String toString() {
        return super.toString() + ", Premia: " + bonus;
    }
}
