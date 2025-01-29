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
        int pgcd;

        pgcd = getPgcd();
        if (this.denominator < 0) {
            this.numerator *= -1;
            this.denominator *= -1;
        }
        if (this.denominator == 1) {
            result = String.valueOf(this.numerator);
        } else if (this.numerator == 0) {
            return String.valueOf(0);
        } else {
            result = "" + (this.numerator / pgcd) + "/" + (this.denominator / pgcd);
        }
        return result;
    }

    public void oppose() {
        this.numerator *= -1;
    }

    public void inverse() {

        try {
            int test = this.denominator / this.numerator;
            int temp = this.denominator;
            this.denominator = this.numerator;
            this.numerator = temp;
        } catch (Exception e) {
            System.out.println("Division par zéro impossible, inversion imposible");
        }
    }

    public boolean superieurA(Fraction f2) {
        if (this.numerator * 1.0 / this.denominator > f2.numerator * 1.0 / f2.denominator) {
            return true;
        } else {
            return false;
        }
    }

    public boolean egalA(Fraction f2) {
        if (this.numerator * 1.0 / this.denominator == f2.numerator * 1.0 / f2.denominator) {
            return true;
        } else {
            return false;
        }
    }

    public int getPgcd() {
        int a = this.numerator;
        int b = this.denominator;
        int pgcd = 1;

        if (a != 0 && b != 0) {
            if (a < 0) {
                a = -a;
            }
            if (b < 0) {
                b = -b;
            }
            while (a != b) {
                if (a < b) {
                    b = b - a;
                } else {
                    a = a - b;
                }
            }
            pgcd = a;
        }
        return pgcd;
    }

    public void plus(Fraction f1, Fraction f2) {
        this.numerator = f1.numerator * f2.denominator + f2.numerator * f1.denominator;
        this.denominator = f1.denominator * f2.denominator;
    }

    public void moins(Fraction f1, Fraction f2) {
        this.numerator = f1.numerator * f2.denominator - f2.numerator * f1.denominator;
        this.denominator = f1.denominator * f2.denominator;
    }

    public void multiplie(Fraction f1, Fraction f2) {
        this.numerator = f1.numerator * f2.numerator;
        this.denominator = f1.denominator * f2.denominator;
    }

    public void divise(Fraction f1, Fraction f2) {
        f2.inverse();
        this.multiplie(f1, f2);
    }
}
