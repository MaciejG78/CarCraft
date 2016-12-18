package pl.com.bottega.jackpot.application;


import com.sun.deploy.util.StringUtils;
import pl.com.bottega.jackpot.model.Fraction;

/**
 * Created by macie on 03.12.2016.
 */
public class FractionTest {
    public static void main(String[] args) {

   try{
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(3, 1, 4);
        Fraction f3 = new Fraction(3.5); //Zapis ma być równoważny 3/5
        Fraction f4 = new Fraction(1, 1111);

     //   Fraction sum = f1.add(f2); //można tak ale można i krócej jak poniżej
     //   System.out.println(sum.toString());

       System.out.println("Suma " + f1 + " oraz " + f2 + " wynosi: " + f1.add(f2).toString());
       System.out.println("Różnica " + f1 + " oraz " + f2 + " wynosi: " + f1.minus(f2).toString());
       System.out.println("Iloczyn " + f1 + " oraz " + f2 + " wynosi: " + f1.multiple(f2).toString());
       System.out.println("Iloraz " + f1 + " oraz " + f2 + " wynosi: " + f1.divide(f2).toString());
       System.out.println("Suma " + f1 + " oraz " + f3 + " wynosi: " + f1.add(f3).toString());
       System.out.println();
       System.out.println("Suma " + f1 + " oraz " + f4 + " wynosi:");
       Fraction sum = f1.add(f4);
//       System.out.printf(sum.formatingNumer(), sum.toStringNom());
       System.out.printf(sum.formatingNumerator(), sum.toStringNumerator());
       System.out.printf("%10s %n", "----------");
       System.out.printf(sum.formatingDenominator(), sum.toStringDenominator());

   } catch (IllegalArgumentException ex){
       System.out.println("Brak symbolu '.' w wartości typu double ;( ");
       return;
   }
    }
}