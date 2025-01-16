public class FractionMain {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(8,7);
        System.out.println(f1);
        Fraction f2 = new Fraction();
        System.out.println(f2);
        Fraction f3 = new Fraction(9);
        System.out.println(f3);
        f1.oppose();
        System.out.println(f1);
        f1.inverse();
        System.out.println(f1);
        Fraction f4 = new Fraction(48, 65);
        System.out.println(f4.superieurA(f1));
        Fraction f5 = new Fraction(0, 130);
        System.out.println(f4.egalA(f5));
        Fraction f6 = new Fraction(120, -150);
        System.out.println(f6);
        Fraction f7 = new Fraction();
        f7.plus(f4, f5);
        System.out.println(f7);
        f7.divise(f1, f5);
        System.out.println(f7);
    }
}
