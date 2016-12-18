package pl.com.bottega.homework.model;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import static java.lang.Math.*;

/**
 * Created by macie on 08.11.2016.
 */

public class WielomianDrugiegoStopnia extends JFrame {

    private double x1;
    private double x2;
    private double delta;
    private double wierzcholek;
    public static final double[][] TablicaWielomianu = new double[61][2];

    public WielomianDrugiegoStopnia(double a, double b, double c) {

        delta = pow(b, 2) - 4 * a * c;

        x1 = (-1 * b - sqrt(delta)) / (2 * a);
        x2 = (-1 * b + sqrt(delta)) / (2 * a);

        wierzcholek = ((-1) * b) / (2 * a);
        double min = wierzcholek - 30;

        for (int i = 0; i <TablicaWielomianu.length; i++) {
            TablicaWielomianu[i][0] = min;
            TablicaWielomianu[i][1] = a * pow(min, 2) + (b * min) + (c);
            min++;
            System.out.println(TablicaWielomianu[i][0] + ", " + TablicaWielomianu[i][1]);

        }
    }

        public void drawLines (Graphics g){
            Graphics2D g2d = (Graphics2D) g;
            double maxX = 0;
            double maxY = 0;
            for (int i = 0; i < TablicaWielomianu.length; i++) {
                if (maxX <= abs(TablicaWielomianu[i][0]))
                    maxX = abs(TablicaWielomianu[i][0]);
            }
            for (int i = 0; i < TablicaWielomianu.length; i++){
                    if (maxY <= abs(TablicaWielomianu[i][1]))
                        maxY = abs(TablicaWielomianu[i][1]);

                }

            double scaleX = 300/maxX;
            double scaleY = 300/maxY;
            System.out.println("Skala osi X wynosi: " + scaleX);
            System.out.println("Skala osi Y wynosi; " + scaleY);

//Osie współrzędnych

            g2d.drawLine(300, 0, 300, 600);
            g2d.drawLine(0, 300, 600, 300);

            //g2d.rotate(Math.toRadians(180));
//Wykres funkcji - nie wiem dlaczego nie mam żadnych wartości w tej tablicy. Same zera.
            for (int i = 0; i < 100; i++) {
                g2d.drawLine(((int) (TablicaWielomianu[i][0]*scaleX))+300, abs((int) (TablicaWielomianu[i][1]*scaleY)-300),
                        ((int) (TablicaWielomianu[i + 1][0]*scaleX))+300, abs((int) (TablicaWielomianu[i + 1][1]*scaleY)-300));

            }

        }


    public void paint(Graphics g) {
        super.paint(g);
        drawLines(g);
    }
    public WielomianDrugiegoStopnia() {
            super("Wykres Funkcji");

            setSize(602, 602);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
        }


// --------- Przekazanie zmiennych x1, x2 do StartWielomianDrugiegoStopnia------------------------------------------

    public double getDelta() { return delta; }
    public double getX1(){
        return x1;
    }
    public double getX2(){
        return x2;
    }

}
