class A {
    // non-nested interfaces can be default or public
    // nested interfaces can be private/protected/public/default
    interface NestedIF {
        boolean isNonNegative(int x);
    }
}

class B implements A.NestedIF {
    public boolean isNonNegative(int x) {
        return x >= 0;
    }
}

public class InterfaceNestedTest {
    public static void main(String[] args) {
        A.NestedIF nif = new B();
        System.out.println(nif.isNonNegative(100));
        System.out.println(nif.isNonNegative(-10));
    }
}
