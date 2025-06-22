class X {
    int a;

    X() {
        System.out.println("Inside X's constructor");
    }
}

class Y extends X {
    int b;

    Y() {
        System.out.println("Inside Y's constructor");
    }
}

class Z extends Y {
    int c;

    Z() {
        System.out.println("Inside Z's constructor");
    }
}

public class MultilevelInheritance {
    public static void main(String[] args) {
        Z z = new Z();
        z.a = 10;
        z.b = 20;
        z.c = 30;
    }
}
