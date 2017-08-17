package pl.com.bottega.algorytmy.sumaCyfr;

public class Cyfry {

    int liczba;

    public Cyfry ( int liczba) {
        this.liczba = liczba;
    }

    public static int sumaCyfr(int liczba) {

        int wynik = 0;
        liczba = Math.abs(liczba);

        while (liczba != 0) {
            wynik += liczba % 10;
            liczba /= 10;
        }
        return wynik;

    }

}




