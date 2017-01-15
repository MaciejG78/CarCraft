package pl.com.bottega.rekrutacja;

import java.util.Scanner;

/**
 * Created by macie on 14.01.2017.
 */
public class NumberInfoWzor {

    int maxDigit, minDigit, digitsSum;

    public NumberInfoWzor(int n) {
        minDigit = 9;
        while(n > 0) {
            int digit = n % 10;
            n /= 10;
            processMax(digit);
            processMin(digit);
            processSum(digit);
        }
    }

    public int getMaxDigit() {
        return maxDigit;
    }

    public int getMinDigit() {
        return minDigit;
    }

    public int getDigitsSum() {
        return digitsSum;
    }

    private void processSum(int digit) {
        digitsSum += digit;
    }

    private void processMin(int digit) {
        if(digit < minDigit)
            minDigit = digit;
    }

    private void processMax(int digit) {
        if(digit > maxDigit)
            maxDigit = digit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int n = scanner.nextInt();
            NumberInfo info = new NumberInfo(n);
            System.out.println(String.format("Min digit: %d", info.getMinDigit()));
            System.out.println(String.format("Max digit: %d", info.getMaxDigit()));
            System.out.println(String.format("Digits sum: %d", info.getDigitSum()));
        }
    }

}