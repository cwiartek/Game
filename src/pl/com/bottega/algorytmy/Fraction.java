package pl.com.bottega.algorytmy;

/**
 * Created by BARTEK on 2017-06-26.
 */
public class Fraction {

   public final long numerator;
   public final long denominator;
   public long calkowita;
   public int dlugosc;

    public Fraction(long numerator, long denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public static Fraction create( long numerator, long denominator) {
        if (denominator == 0)
            return null;
        return new Fraction(numerator, denominator);
    }


    public  Fraction add(Fraction drugiUlamek){

        return new Fraction ((getNumerator() *drugiUlamek.getDenominator() + getDenominator() *drugiUlamek.getNumerator()), (getDenominator() *drugiUlamek.getDenominator()));
    }
    public  Fraction substract(Fraction drugiUlamek){

        return new Fraction((getNumerator() *drugiUlamek.getDenominator() - getDenominator() *drugiUlamek.getNumerator()), (getDenominator() *drugiUlamek.getDenominator()));
    }
    public Fraction multiple(Fraction drugiUlamek) {

        return new Fraction(getNumerator() * drugiUlamek.getNumerator(), getDenominator() * drugiUlamek.getDenominator());
    }
    public Fraction inverse() {

        return new Fraction(denominator, numerator);
    }
    public Fraction divide(Fraction drugiUlamek) {
        return multiple(drugiUlamek.inverse());
    }
    public long getIntegerPart()
    {
        return calkowita  = getNumerator() / getDenominator();
    }
    public long getNumerator()
    {
           return this.numerator;
    }
    public long getDenominator()
    {
        return this.denominator;
    }

    public String toString() {
        String.valueOf(numerator);
        String.valueOf(denominator);


        return numerator + "\n" + calkowita +  "------" + "\n" + denominator;
    }






}





