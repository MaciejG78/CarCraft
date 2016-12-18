package pl.com.bottega.jackpot.model;


/**
 * Created by macie on 03.12.2016.
 */
public class Fraction {

    private final long numerator; //licznik
    private final long denominator; //mianownik

    public Fraction(long numerator, long denominator){
        if (denominator == 0)
            throw new IllegalArgumentException("Pamiętaj cholero, nie dziel przez zero !!!");

        if (numerator < 0 && denominator < 0){
            this.numerator = -numerator;
            this.denominator = -denominator;
        }
        else {
            this.numerator = numerator;
            this.denominator = denominator;
        }

    }

    public Fraction(long integerPart, long numerator, long denominator){
        this(integerPart*denominator + numerator, denominator);

    }
    //Zamiana na ułamek jak ktoś wpisze z kropką
    public Fraction(double value) throws IllegalArgumentException{
        String string = Double.toString(value);

        if (string.contains(".")) {
        String numeratorString = string.split("\\.")[0];
        String denumeratorString = string.split("\\.")[1];
            this.numerator = (long) (Long.parseLong(numeratorString) * Math.pow(10, denumeratorString.length()) + Long.parseLong(denumeratorString));
            this.denominator = (long) Math.pow(10, denumeratorString.length());
        }
        else {
            throw new IllegalArgumentException("String " + string + " does not contain '.'");
        }
    }

    //Metody
    //Suma
    public Fraction add(Fraction summand){
        long localNumerator = this.numerator;
        long localDenominator = this.denominator;
        if(denominator == summand.denominator){
            return new Fraction(localNumerator + summand.numerator, summand.denominator);
        }
        else {
            localNumerator = this.numerator * summand.denominator + this.denominator * summand.numerator;
            localDenominator = this.denominator * summand.denominator;

        }

        return new Fraction(localNumerator, localDenominator);
    }

    //Minus
    public Fraction minus(Fraction minus){
        long localNumerator = this.numerator;
        long localDenominator = this.denominator;
        if(localDenominator == minus.denominator){
            return new Fraction(localNumerator - minus.numerator, minus.denominator);
        }
        else {
            localNumerator = this.numerator * minus.denominator - this.denominator * minus.numerator;
            localDenominator = this.denominator * minus.denominator;
        }

        return  new Fraction (localNumerator, localDenominator);
    }

    //Iloczyn
    public Fraction multiple(Fraction multiply){//mnożenie
        return new Fraction(numerator * multiply.numerator, denominator * multiply.denominator);
    }

    //Iloraz
    public Fraction divide(Fraction dividor){
        return multiple(dividor.inverse());
    }

    //Odwrócenie do dzielenia
    public Fraction inverse(){
        return new Fraction(denominator, numerator);
    }

    //Wyciągnięcie części całkowitej
    public long getIntegerPart(){
        return numerator / denominator;
    }

    //toString
    public String toString(){
    return numerator + " / " + denominator;
}

    public String toStringNumerator() {
        return numerator + "";
    }

    public String toStringDenominator() {
        return denominator + "";
    }

    public String formatingNumerator() {
        return "%" + (5 + toStringNumerator().length() / 2) + "s %n";
    }

    public String formatingDenominator() {
        return "%" + (5 + toStringDenominator().length() / 2) + "s %n";
    }
}
