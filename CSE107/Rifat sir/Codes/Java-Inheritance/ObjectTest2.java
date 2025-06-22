import java.util.HashMap;
import java.util.Objects;

class Circle {
    Point center;
    int radius;

    Circle(int x, int y, int r) {
        center = new Point(x, y);
        this.radius = r;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Circle)) {
            return false;
        }
        Circle circle2 = (Circle) o;
        if (this.center.equals(circle2.center) && this.radius == circle2.radius)
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, radius);
    }
}

public class ObjectTest2 {
    public static void main(String[] args) {
        Circle c1 = new Circle(10, 20, 30);
        Circle c2 = new Circle(10, 20, 30);
        System.out.println(c1.equals(c2));
        System.out.println(c1 == c2);
        HashMap<Circle, String> m = new HashMap<>();
        m.put(c1, "Hello");
        System.out.println(m.get(c2));
    }
}
