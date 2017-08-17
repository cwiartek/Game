package pl.com.bottega.algorytmy;


import java.util.regex.Pattern;

public class SystemyLiczbowe {

    public static void main(String[] args) {
        System.out.println(Przeliczanie(10, 16));

        System.out.println(convertFrom("A", 16));

    }


    public static String Przeliczanie(int n, int k) {
        if ( k>36 || k <=0 || n<0)
            throw new IllegalArgumentException();

        StringBuilder sb = new StringBuilder();

        if (k == 1) {
            for (int i=0; i<n; i++)
                sb.append('0');

        } else {
            while (n > 0) {
                char x = 'A' + 1;
                int mod = n % k;
                String digit;
                if (mod < 10)
                    digit = String.valueOf(mod);
                else
                    digit = String.valueOf('A' + mod - 10);
                sb.insert(0, digit);
                n /= k;
            }

        }
            return sb.toString();
        }



        public static int convertFrom ( String n , int k) {

        char [] charDigits = n.toCharArray();
        int result = 0;
        int power =1;

        for ( int i=0; i<charDigits.length; i++) {
            char digit = charDigits[charDigits.length - i -1];
            int digitDecimal = toDecimal(digit);
            result += digitDecimal*power;
            power *= k;

        }
        return result;

        }

    private static int toDecimal(char n) {
        if ( n >= '0' && n <= '9')
            return n - '0';
        else if ( n >= 'A' && n<= 'Z')
            return n - 'A' + 10;
        else
            throw new IllegalArgumentException();
    }



}
