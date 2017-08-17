package pl.com.bottega.algorytmy;


import pl.com.bottega.algorytmy.Fraction;

public class FractionTest {

    public static void main(String[] args) {

        Fraction f1 = Fraction.create(1, 2);
        Fraction f2 = Fraction.create(1, 2);

        Fraction sum = f1.add(f2);
        System.out.println(sum.toString());




        System.out.println("Wynik dodawania ulamkow:");
        System.out.println(sum.getNumerator());
        System.out.println("---");
        System.out.println(sum.getDenominator());

        Fraction roznica = f1.substract(f2);

        System.out.println("Wynik odejmowania ulamkow:");
        System.out.println(roznica.getNumerator());
        System.out.println("---");
        System.out.println(roznica.getDenominator());

        Fraction mnozenie = f1.multiple(f2);

        System.out.println("Wynik mnozenia ulamkow:");
        System.out.println(mnozenie.getNumerator());
        System.out.println("---");
        System.out.println(mnozenie.getDenominator());

        Fraction odwracanie = f1.inverse();
        System.out.println("Wynik odwracania ulamka:");
        System.out.println(odwracanie.getNumerator());
        System.out.println("---");
        System.out.println(odwracanie.getDenominator());

        Fraction dzielenie = f1.divide(f2);
        System.out.println("Wynik dzielenia ulamkow:");
        System.out.println(dzielenie.getNumerator());
        System.out.println("---");
        System.out.println(dzielenie.getDenominator());

        long czescCalkowita = f1.getIntegerPart();
        System.out.println("Czesc calkowita ulamka wynosi:" + " " + czescCalkowita);

        System.out.println("Numerator:" + " " + f1.getNumerator());
        System.out.println("Denominator: " + " " + f1.getDenominator());





    }

}
