import java.util.HashMap;

record MyPoint(int x, int y) {   
}

public class RecordTest {
    public static void main(String[] args) {
        MyPoint p1 = new MyPoint(10, 20);        
        System.out.println(p1);
        System.out.println(p1.x());
        System.out.println(p1.y());
        MyPoint p2 = new MyPoint(10, 20);
        System.out.println(p2);
        System.out.println(p1.equals(p2));
        System.out.println(p1 == p2);
        HashMap<MyPoint, String> m = new HashMap<>();
        m.put(p1, "Hello");
        System.out.println(m.get(p2));
    }
}
