class Outer1 {
    private int outer_x = 100;

    Outer1() {
        System.out.println("Outer1 Constructor");
    }

    void test() {
        Inner inner = new Inner();
        inner.display();
    }

    // this is an inner class
    class Inner {
        int inner_x = 200;

        Inner() {
            System.out.println("Inner Constructor");
        }

        void display() {
            System.out.println(outer_x);
        }
    }
}

public class InnerClassDemo1 {
    public static void main(String[] args) {
        Outer1 outer = new Outer1();
        outer.test();
        Outer1.Inner innerObj = outer.new Inner();
        innerObj.display();
    }
}
