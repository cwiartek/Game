package pl.com.bottega.algorytmy.Litery;


import java.util.Scanner;

public class CharsCounterApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj napis w ktorym mam sprawdzic ilosc malych i duzych liter:");

        String text = scanner.nextLine();

        CharsCount charsCount = countChars(text);
        System.out.println("Lower case count:" + charsCount.lowerCaseCount());
        System.out.println("Upper case count:" + charsCount.upperCaseCount());
    }


    public static CharsCount countChars(String text) {
        int lowerCaseCount = 0;
        int upperCaseCount = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c))
                if (Character.isUpperCase(c))
                    upperCaseCount++;
                else
                    lowerCaseCount++;
        }
        return new CharsCount(lowerCaseCount, upperCaseCount);
    }

}

