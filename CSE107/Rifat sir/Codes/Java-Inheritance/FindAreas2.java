abstract class Figure2 {
    double d1, d2;

    Figure2(double a, double b) {
        this.d1 = a;
        this.d2 = b;
    }

    abstract double area();
}

class Rectangle2 extends Figure2 {
    Rectangle2(double a, double b) {
        super(a, b);
    }

    @Override
    public double area() {
        return d1 * d2;
    }
}

class Triangle2 extends Figure2 {
    Triangle2(double a, double b) {
        super(a, b);
    }

    @Override
    public double area() {
        return (d1 * d2) / 2;
    }
}

public class FindAreas2 {
    public static void main(String[] args) {
        Rectangle2 r = new Rectangle2(9, 5);
        Triangle2 t = new Triangle2(10, 8);

        Figure2 ref;

        ref = r;
        System.out.println("Area: " + ref.area());

        ref = t;
        System.out.println("Area: " + ref.area());
    }
}
