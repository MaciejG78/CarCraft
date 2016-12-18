package pl.com.bottega.homework.application;

import pl.com.bottega.homework.model.WielomianDrugiegoStopnia;

import javax.swing.SwingUtilities;

/**
 * Created by macie on 08.11.2016.
 */
public class StartWielomianDrugiegoStopnia {
    public static void main(String[] args) {

//Testowane wartości to: 1,3,4 wynik -1 i -3; 2,4,50 wynik to brak miejsc zerowych; -2,4,-2 wynik to x=1
        double a = -2;
        double b = 4;
        double c = -2;


        if (a == 0) {
            System.out.print("Wartość a musi być różna od 0");
            return;
        }
        WielomianDrugiegoStopnia Wielomian = new WielomianDrugiegoStopnia(a, b, c);

        double delta = Wielomian.getDelta();
        //} else {

            double x1 = Wielomian.getX1();
            double x2 = Wielomian.getX2();

            //Wyświetlenie w ładnej postaci wielomianu z uwzględnieniem watrości ujemnych i dodatnich
            System.out.println("Obliczenia dla równania: ax^2 + bx + c = 0, dla następujących parametrów: a = " + a + ", b = " + b + ", c = " + c);

            if (a != 0 && a != 1 && a != -1)
                System.out.print(a + "x^2 ");
            if (a == 1)
                System.out.print("x^2 ");
            if (a == -1)
                System.out.print("-1*x^2 ");
            if (b == 1)
                System.out.print("x ");
            if (b == -1)
                System.out.print("-x ");
            if (b < 0 && b != -1)
                System.out.print(b + "x ");
            if (b > 0 && b != 1)
                System.out.print("+ " + b + "x ");
            if (c < 0)
                System.out.print(c + " = 0");
            if (c > 0)
                System.out.print("+ " + c + " = 0");
            if (c == 0)
                System.out.print(" = 0");

            System.out.println(" ");

            if (delta < 0)
                System.out.println("Wielomian nie ma miejsc zerowych");
            else if (x1 == x2)
                System.out.println("Wynik x1 = x2 wynosi: " + x1);
            else
                System.out.println("Wynik: x1 = " + x1 + ", x2 = " + x2);


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
            new WielomianDrugiegoStopnia().setVisible(true);
            }
        });

        //}
    }




}

