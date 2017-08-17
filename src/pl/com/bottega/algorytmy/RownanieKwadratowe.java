package pl.com.bottega.algorytmy;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RownanieKwadratowe {

    private static BigDecimal a;
    private static BigDecimal b;
    private static BigDecimal c;
    private static BigDecimal delta;
    private static BigDecimal zero;
    private static int warunek;
    private static BigDecimal x1;
    private static BigDecimal x2;
    private static BigDecimal x;
    private static BigDecimal ekstremum;
    private static BigDecimal argumentEkstremum;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        BigDecimal a = readParameter("a");
        BigDecimal b = readParameter("b");
        BigDecimal c = readParameter("c");


        RownanieKwadratowe rownanie = new RownanieKwadratowe(a, b, c);

        System.out.println(generateGeneralForm(a,b,c));

        rownanie.obliczBigDelte(a,b,c);
        rownanie.obliczMiejscaZerowe(delta);
        rownanie.obliczEkstremum(a, rownanie);

        System.out.println("Delta = " + delta);

    }
       private BigDecimal obliczBigDelte( BigDecimal a, BigDecimal b, BigDecimal c) {

        return delta = (b.multiply(b)).subtract(a.multiply(c).multiply(BigDecimal.valueOf(4)));
    }
    private void obliczMiejscaZerowe (BigDecimal delta ) {

        zero = new BigDecimal("0");
        warunek = delta.compareTo(zero);
        if (warunek <0) {
            System.out.println("Delta mnniejsza od zera - funkcja nie posiada miejsc zerowych");
            }
        else if (warunek > 0) {

            this.x1 = (b.multiply(BigDecimal.valueOf(-1)).add(sqrt(delta,2))).divide(BigDecimal.valueOf(2).multiply(a));
            this.x2 = (b.multiply(BigDecimal.valueOf(-1)).subtract(sqrt(delta,2))).divide(BigDecimal.valueOf(2).multiply(a));

            System.out.println("Funkcja posiada dwa miejsca zerowe x1=" + x1 + " oraz x2=" + x2);
        }
        else if (warunek ==0) {

            x = b.multiply(BigDecimal.valueOf(-1)).divide(BigDecimal.valueOf(2).multiply(a));
            System.out.println("Funkcja posiada jedno miejsce zerowe x=" + x);
        }
    }
    private void obliczEkstremum ( BigDecimal a, RownanieKwadratowe rownanie) {

        zero = new BigDecimal("0");
        warunek = a.compareTo(zero);

        if ( warunek > 0) {
            ekstremum = rownanie.ekstremum(delta, a);
            argumentEkstremum = rownanie.argumentEkstremum(b,a);

            System.out.println("Funkcja posiada minimum rowne " + ekstremum + " w argumencie " + argumentEkstremum);
        }
        else if (warunek <0) {
            ekstremum = rownanie.ekstremum(delta, a);
            argumentEkstremum = rownanie.argumentEkstremum(b,a);

            System.out.println("Funkcja posiada maximum rowne " + ekstremum + " w argumencie " + argumentEkstremum);
        }
    }
    private BigDecimal ekstremum (BigDecimal delta, BigDecimal a)

    {
        return (delta.multiply(BigDecimal.valueOf(-1))).divide(a.multiply(BigDecimal.valueOf(4)));
    }

    private BigDecimal argumentEkstremum (BigDecimal b, BigDecimal a) {

       return (b.multiply(BigDecimal.valueOf(-1))).divide(a.multiply(BigDecimal.valueOf(2)));
    }

    private static String generateGeneralForm(BigDecimal a, BigDecimal b, BigDecimal c) {
        String bSign = b.compareTo(BigDecimal.valueOf(0)) >0 ? "+" : "";
        String cSign = c.compareTo(BigDecimal.valueOf(0)) >=0 ? "+" : "";
        return "Rownanie kwadratowe: " + a +"x^2" + bSign + b + "x" + cSign + c;
    }

    private static BigDecimal readParameter(String coefficent) {

        System.out.println("Podaj parametr " + coefficent + ": ");
        try {
            return scanner.nextBigDecimal();
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Wprowadzono niepoprawne wartosci ");
        }
    }

    public static BigDecimal sqrt(BigDecimal delta, int PRECISION)
    {

        BigInteger n = delta.movePointRight(PRECISION << 1).toBigInteger();

        int bits = (n.bitLength() + 1) >> 1;
        BigInteger ix = n.shiftRight(bits);
        BigInteger ixPrev;

        double sq = Math.sqrt(delta.doubleValue());


        BigDecimal sqBd = BigDecimal.valueOf(sq);


        do {
            ixPrev = ix;
            ix = ix.add(n.divide(ix)).shiftRight(1);
            Thread.yield();
        } while (ix.compareTo(ixPrev) != 0);

        return new  BigDecimal(ix, PRECISION);
}

    public RownanieKwadratowe(BigDecimal a, BigDecimal b, BigDecimal c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}

