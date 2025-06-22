class Outer2 {
    int outer_x = 100;

    Outer2() {
        System.out.println("Outer2 Constructor");
    }

    void test() {
        Inner inner = new Inner();
        inner.display();
    }

    class Inner {
        int y = 10; // y is local to Inner
        int outer_x = 200;

        Inner() {
            System.out.println("Inner Constructor");
        }

        void display() {
            System.out.println(Outer2.this.outer_x);
        }
    }

    void showy() {
        //System.out.println(y); // error, y not known here!
    }
}

public class InnerClassDemo2 {
    public static void main(String[] args) {
        Outer2 outer = new Outer2();
        outer.test();
    }
}
