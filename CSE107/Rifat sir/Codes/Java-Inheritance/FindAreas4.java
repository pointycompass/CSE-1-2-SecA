abstract class Fig2 {
    abstract double area(double a, double b);
}

public class FindAreas4 {
    public static void main(String[] args) {
        Fig2 rec = new Fig2() {
            double area(double d1, double d2) {
                return d1 * d2;
            }
        };
        System.out.println(rec.area(10, 20));
        Fig2 tr = new Fig2() {
            double area(double d1, double d2) {
                return d1 * d2 / 2;
            }
        };
        System.out.println(tr.area(10, 20));
    }
}