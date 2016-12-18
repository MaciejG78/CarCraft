package pl.com.bottega.homework;

import java.util.Scanner;

/**
 * Created by macie on 12.11.2016.
 */
public class QuadraticEquation {
    private static final double ALMOST_ZERO = 0;

    public static void main(String[] args) {

        double x1;
        double x2;
        double y;

        Scanner keyboard = new Scanner( System.in );
        System.out.println("Enter values for A, B and C for the equation Ax^2 + Bx + C = 0");
        System.out.println("Enter a value for A: ");
        double a = checkDbl(keyboard);
        System.out.println("Enter a value for B: ");
        double b = checkDbl(keyboard);
        System.out.println("Enter a value for C: ");
        double c = checkDbl(keyboard);
        System.out.println("Solving " + a + "x^2 +" + b + "x + " + c + " = 0");


/*
        double a = ReadParam("a");

        //TODO walidacja a:

        double b = ReadParam("b");
        double c = ReadParam("c");

        displayCanonicalForm(a, b, c);
*/
        double delta = Math.pow(b, 2) - (4 * a * c);


        if (delta > 0){
            x1 = (-b + Math.sqrt(delta)) / (2 * a);
            x2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("Value of x1 = " + x1 + ", value of x2 = " + x2);
        }
        else if (delta < 0){
            System.out.println("No intersection with the X axis");
        }
        else{
            x1 = (-b / (2 * a));
            System.out.println("Value of x1 = x2 = " + x1);
        }

        System.out.println("For x = 0 value of y = " + y);


        //double extremumArgument =
        //double extremumValue =
}
/*
    private static void test(double a) {
        if (a != 0){
            System.out.println("A can not be 0 value");
            System.out.println("Enter correct value for A: ");
            }


    }
*/
    /*
        private static double ReadParam(String b) {
        }

        private static void displayCanonicalForm(double a, double b, double c) {
        }

    */
    public static double checkDbl(Scanner keyboard) {
        if (keyboard.hasNextDouble())
        {
            return keyboard.nextDouble();
        }
        else
        {
            System.out.println("Wrong way, bad value !!!");
            System.exit(0);
        }
        return 0;
    }
}