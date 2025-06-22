abstract class Fig {
    double d1, d2;

    Fig(double a, double b) {
        this.d1 = a;
        this.d2 = b;
    }

    abstract double area();
}

public class FindAreas3 {
    public static void main(String[] args) {
        Fig rec = new Fig(10, 20) {
            double area() {
                return d1 * d2;
            }
        };
        System.out.println(rec.area());
        Fig tr = new Fig(10, 20) {
            double area() {
                return d1 * d2 / 2;
            }
        };
        System.out.println(tr.area());
    }
}
