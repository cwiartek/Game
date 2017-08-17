package pl.com.bottega.algorytmy.palindrom;

import java.util.Scanner;

public class IsPalindrom {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("Wpisz dowolny napis");

            String napis = scanner.nextLine();

            String isNot = isPalindrom(napis)? "" : "nie" ;

            System.out.println("Wpisales napis " + napis + ". Twoj napis " + isNot + " jest Palindromem");

        }
    }

    public static boolean isPalindrom (String data) {

        if ( data ==null)
            throw new NullPointerException("The input is null");

        int n = data.length();

        for ( int i=0; i<n/2; i++) {
            if (data.charAt(i)!=data.charAt(n-1-i))
                return false;
        }
        return true;


    }
}
