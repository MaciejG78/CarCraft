package pl.com.bottega.homework;

/**
 * Created by macie on 12.11.2016.
 */
public class QuadraticPolynomial {
    private static final double ALMOST_ZERO = 0.00000000001;
    double a;
    double b;
    double c;

    Double x1;
    Double x2;
    boolean ready = false;


    public QuadraticPolynomial(double a, double b, double c) {
        if (Math.abs(a) < ALMOST_ZERO)
            //rzucamy wyjątkiem
            throw new IllegalArgumentException("|a| can not be less than " + ALMOST_ZERO);

        this.a = a;
        this.b = b;
        this.c = c;
        //Kalkulacje
    }
/*
    public double[] getRoots(){
        if (!ready)
            //pierwsze obliczenie

        //return

    }

    public double value(double x){
        return a * Math.pow(x, 2) + b *x + c;

    }

    public double[] values(double[] x){
        double[] result = new double[x.length];
        for (int i = 0; i < x.length; i++){
            result[i] = value(x[i]);
        }
        return result;
    }

}
*/