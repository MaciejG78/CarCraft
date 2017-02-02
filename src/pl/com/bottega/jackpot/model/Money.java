package pl.com.bottega.jackpot.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;

/**
 * Created by macie on 20.11.2016.
 */

//value object - immutable
public class Money {
    //Definiujemy domyślną wartość PLN i 0 złotych
    public static final Currency DEFAULT_CURRENCY = Currency.getInstance("PLN");
    public static final Money ZERO = new Money(BigDecimal.ZERO, DEFAULT_CURRENCY);

    private final BigDecimal value;
    private final Currency currency;


    public Money(String value, String currency){
        this.value = new BigDecimal(value); //Ze Stringa zrobi wartość dokładną
        this.currency = Currency.getInstance(currency); //Zwróci kod kraju, trzeba tylko przekazać np. PLN

    }

    public Money(BigDecimal newValue, Currency currency) {
        this.value = newValue;
        this.currency = currency;
    }

        //przeliczenie kasy moneta * ilość
    public Money multiply(int multiplicand){
        BigDecimal newValue = value.multiply(new BigDecimal(multiplicand));
        return new Money(newValue, currency);

    }
    //sumowanie wartości poszczególnych monet
    public Money add(Money summand){
        if (!this.currency.equals(summand.currency))//sprawdzamy - porównujemy walutę
            throw new IllegalArgumentException("different currency");

        BigDecimal sum = this.value.add(summand.value);
        return new Money(sum, currency); //returnujemy sumaryczną kwotę
    }

    public Money minus(Money difference){
        if (!this.currency.equals(difference.currency))//sprawdzamy - porównujemy walutę
            throw new IllegalArgumentException("different currency");

        BigDecimal minus = this.value.subtract(difference.value);
        return new Money(minus, currency); //returnujemy sumaryczną kwotę
    }

    //dzielenie Monet
    public Money div(Money divided){
        if (!this.currency.equals(divided.currency))//sprawdzamy - porównujemy walutę
            throw new IllegalArgumentException("different currency");

        BigDecimal div = this.value.divide(divided.value, 0, RoundingMode.DOWN);

        return new Money(div, currency);

       //     return new Money(div, currency); //returnujemy sumaryczną kwotę
       //   return equals(div);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money)) return false;

        Money money = (Money) o;

        if (!value.equals(money.value)) return false;
        return currency.equals(money.currency);

    }

    @Override
    public int hashCode() {
        int result = value.hashCode();
        result = 31 * result + currency.hashCode();
        return result;
    }

    @Override

    public String toString() {
        return value + " " + currency;
    }

    public BigDecimal getValue() {
        return value;
    }
}
