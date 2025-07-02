interface I1 {
    void f1();
}

interface I2 {
    void f2();
}

interface I3 extends I1, I2 {
    void f3();
}

class MyClass implements I3 {
    public void f1() {
        System.out.println("Implement f1");
    }
    public void f2() {
        System.out.println("Implement f2");
    }
    public void f3() {
        System.out.println("Implement f3");
    }
}

public class InterfaceExtendsTest {
    public static void main(String[] args) {
        MyClass m = new MyClass();
        m.f1();
        m.f2();
        m.f3();
    }
}
