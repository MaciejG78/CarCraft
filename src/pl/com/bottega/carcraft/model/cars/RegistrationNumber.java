package pl.com.bottega.carcraft.model.cars;

/**
 * Created by macie on 19.11.2016.
 */
public class RegistrationNumber {

    private final String firstPart;
    private final String lastPart;

    public RegistrationNumber(String firstPart, String lastPart) {
        //TODO - walidacja
        this.firstPart = firstPart;
        this.lastPart = lastPart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegistrationNumber that = (RegistrationNumber) o;

        if (!firstPart.equals(that.firstPart)) return false;
        return lastPart.equals(that.lastPart);

    }

    @Override
    public int hashCode() {
        int result = firstPart.hashCode();
        result = 31 * result + lastPart.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return firstPart.toUpperCase() + " " + lastPart.toUpperCase();
    }
}
