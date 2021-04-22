package JavaCurrencyFormatter;
//created by J.M.

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        Locale indiaLocale = new Locale("en","IN");

        NumberFormat indian = NumberFormat.getCurrencyInstance(indiaLocale);
        String india=indian.format(payment);

        String us = NumberFormat.getCurrencyInstance(Locale.US).format(payment);

        String china = NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment);
        String france = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment);

        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}
