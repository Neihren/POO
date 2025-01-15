public class Point {
    
    private double x;
    private double y;

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point point) {
        this.x = point.x;
        this.y = point.y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void setX(double newX) {
        this.x = newX;
    }
    
    public void setY(double newY) {
        this.y = newY;
    }

    public String toString() {
        String result;

        result = "\n####################################";
        result += "\n# Point ";
        result += "\n# x = " + this.x;
        result += "\n# y = " + this.y;
        result += "\n####################################";
        return result;
    }

    public void move(double newX, double newY) {
        this.x = newX;
        this.y = newY;
    }

    public void ySymmetry() {
        this.x *= -1; 
    }

    public void xSymmetry() {
        this.y *= -1;
    }

    public void oSymmetry() {
        this.ySymmetry();
        this.xSymmetry();
    }

    public void permutation() {
        double temp;
        temp = this.x;
        this.x = this.y;
        this.y = temp;
    }
}
