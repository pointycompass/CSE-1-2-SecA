class C {
    int i;

    void show() {
    }
}

class D extends C {
    int i; // this i hides the i in C

    D(int a, int b) {
        super.i = a; // i in C
        i = b; // i in D
    }

    void show() {
        System.out.println("i in superclass: " + super.i);
        System.out.println("i in subclass: " + i);
        super.show();
    }
}

public class UseSuper {
    public static void main(String[] args) {
        D subOb = new D(1, 2);
        subOb.show();
    }
}
