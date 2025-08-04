import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ApplyLambda {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable Interface");
            }
        };

        Runnable r1 = () -> System.out.println("Runnable Interface");

        Runnable r2 = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
        };

        Thread t = new Thread(r);
        t.start();

        Thread t1 = new Thread(r1);
        t1.start();

        Thread t2 = new Thread(r2);
        t2.start();

        List<MyClass> al = new ArrayList<>();

        al.add(new MyClass(1, "C"));
        al.add(new MyClass(3, "A"));
        al.add(new MyClass(2, "E"));
        al.add(new MyClass(5, "B"));
        al.add(new MyClass(4, "D"));
        al.add(new MyClass(6, "F"));

        /*
         * Collections.sort(al, new Comparator<MyClass>() {
         * 
         * @Override
         * public int compare(MyClass o1, MyClass o2) {
         * return o1.getName().compareTo(o2.getName());
         * }
         * });
         */

        Collections.sort(al, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        al.forEach(e -> System.out.println(e.getId() + ", " + e.getName()));
        System.out.println();

        Collections.sort(al, (o1, o2) -> {
            if (o1.getId() == o2.getId())
                return o1.getName().compareTo(o2.getName());
            else
                return o1.getId() - o2.getId();
        });
        al.forEach(e -> System.out.println(e.getId() + ", " + e.getName()));
        System.out.println();

        Collections.sort(al, Comparator.comparing(MyClass::getId).thenComparing(MyClass::getName));
        al.forEach(e -> System.out.println(e.getId() + ", " + e.getName()));
        System.out.println();
    }
}
