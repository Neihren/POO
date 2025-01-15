public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction() {
        this.numerator = 0;
        this.denominator = 1;
    }

    public Fraction(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public String toString() {
        String result;
        if (this.denominator == 1) {
            result = String.valueOf(this.numerator/this.denominator);
        } else {
            result = "" + this.numerator + "/" + this.denominator;
        }
        return result;
    }

    public void oppose() {
        this.numerator *= -1;
    }

    public void inverse() {
        int temp = this.denominator;
        this.denominator = this.numerator;
        this.numerator = temp;
    }

    public boolean superieurA(Fraction f2) {
        if (this.numerator*1.0 / this.denominator > f2.numerator*1.0 / f2.denominator) {
            return true;
        } else {
            return false;
        }
    }

    
}
