package pl.com.bottega.javastart.tests.Files;

/**
 * Created by macie on 10.01.2017.
 */
public class Factorial {
    public static void main(String[] args) {
        Factorial f = new Factorial();
        int factArg = 5;
        int result = f.factorial(factArg);
        System.out.println("Silnia " + factArg + " = " + result);
    }

    public int factorial(int n) {
        return n > 1 ? n * factorial(n - 1) : 1;
    }
}



/* Wersja z zapisem wyników do plików
public class Factorial {
    public static void main(String[] args) throws IOException {
        Factorial f = new Factorial();
        int factArg = 5;
        int result = f.factorial(factArg);
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("plik.txt")));
        writer.write("Silnia " + factArg + " = " + result);
        writer.close();
        System.out.println("Silnia " + factArg + " = " + result);
    }

    public int factorial(int n) {
        return n > 1 ? n * factorial(n - 1) : 1;
    }
}
 */