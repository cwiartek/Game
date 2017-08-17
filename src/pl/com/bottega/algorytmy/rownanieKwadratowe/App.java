package pl.com.bottega.algorytmy.rownanieKwadratowe;


import java.math.BigDecimal;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Wprowadz wspolczynniki rownania");
            System.out.print("A =");
            BigDecimal a = scanner.nextBigDecimal();
            if (a.equals(BigDecimal.ZERO))
                System.out.println("To nie jest rownanie kwadratowe");
            else {
                System.out.print("B =");
                BigDecimal b = scanner.nextBigDecimal();
                System.out.print("C =");
                BigDecimal c = scanner.nextBigDecimal();

                funkcjaKwadratowa f = new funkcjaKwadratowa(a, b, c);

                System.out.println("Ilosc rozwiazan rownania: " + f.iloscMiejscZerowych());
                if (f.iloscMiejscZerowych() == 0)
                    System.out.println("Nie ma rozwiazan");
                else if (f.iloscMiejscZerowych() == 1)
                    System.out.println("Jedno rozwiazanie:" + f.x0());
                else
                    System.out.println("Dwa rozwiazania:");
                System.out.println("x1 = " + f.x1());
                System.out.println("x2 = " + f.x2());


          //  System.out.println("Ekstremum = " + f.ekstremu());
        }
    }}
}
