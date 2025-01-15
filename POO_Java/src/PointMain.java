public class PointMain {
    public static void main(String[] args) {
        Point a = new Point(12, 48);
        System.out.println(a);
        System.out.println(a.getX());
        System.out.println(a.getY());
        a.setX(24);
        a.setY(36);
        System.out.println(a);
        a.move(25, 8);
        System.out.println(a);
        a.ySymmetry();
        System.out.println(a);
        a.xSymmetry();
        System.out.println(a);
        a.oSymmetry();
        System.out.println(a);
        a.permutation();
        System.out.println(a);
    }
}
