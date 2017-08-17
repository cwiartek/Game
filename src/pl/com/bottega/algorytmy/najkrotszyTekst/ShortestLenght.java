package pl.com.bottega.algorytmy.najkrotszyTekst;

public class ShortestLenght {

    public static int findShortestLenght (String [] data) {

        if (data.length == 0)
            return 0;
        int shortestLenght = Integer.MAX_VALUE;
        for ( String text : data) {
            if (text.length()< shortestLenght)
                shortestLenght = text.length();
        }
        return shortestLenght;
    }
}
