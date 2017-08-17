package pl.com.bottega.algorytmy.sumaCyfr;

import java.util.Scanner;

public class SumaCyfrApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbe ktorej nalezy wyliczyc sume cyfr:");
        int liczba = scanner.nextInt();

        Cyfry cyfry = new Cyfry(liczba);

        System.out.println(cyfry.sumaCyfr(liczba));
    }
}
