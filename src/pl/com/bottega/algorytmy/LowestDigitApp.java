package pl.com.bottega.algorytmy;

import java.util.Scanner;

public class LowestDigitApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj liczbe ");
        int number = scanner.nextInt();

        LowestDigit lowestDigit = new LowestDigit(number);

        System.out.println(lowestDigit.lowestNumber(number));
    }
}
