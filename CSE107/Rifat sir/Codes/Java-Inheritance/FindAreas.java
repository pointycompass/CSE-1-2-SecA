class Figure {
    double d1, d2;

    Figure(double a, double b) {
        this.d1 = a;
        this.d2 = b;
    }

    public double area() {
        System.out.println("Area for Figure is undefined");
        return 0;
    }
}

class Rectangle extends Figure {
    Rectangle(double a, double b) {
        super(a, b);
    }

    @Override
    public double area() {
        return d1 * d2;
    }
}

class Triangle extends Figure {
    Triangle(double a, double b) {
        super(a, b);
    }

    @Override
    public double area() {
        return (d1 * d2) / 2;
    }
}

public class FindAreas {
    public static void main(String[] args) {
        Figure f = new Figure(10, 10);
        Rectangle r = new Rectangle(9, 5);
        Triangle t = new Triangle(10, 8);

        Figure ref;

        ref = f;
        System.out.println("Area: " + ref.area());

        ref = r;
        System.out.println("Area: " + ref.area());

        ref = t;
        System.out.println("Area: " + ref.area());
    }
}
