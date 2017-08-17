package pl.com.bottega.algorytmy;

public class LowestDigit {

    int number;

    public LowestDigit (int number) {
        this.number = number;
    }

    public static int lowestNumber (int number ) {
        if (number == 0)
            return 0;
        int lowestNumber = 9;
        number = Math.abs(number);

        while (number>0) {
            if (number % 10 < lowestNumber)
                lowestNumber = (number % 10);
            number = number /10;
        }
        return lowestNumber;


    }
}

