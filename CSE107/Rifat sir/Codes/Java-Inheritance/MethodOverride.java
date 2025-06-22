class Base {
    int a;

    Base(int a) {
        this.a = a;
    }

    void show() {
        System.out.println(a);
    }
}

class Child extends Base {
    int b;

    Child(int a, int b) {
        super(a);
        this.b = b;
    }

    // the following method overrides Base class's show()
    @Override // this is an annotation (optional but recommended)
    void show() {
        System.out.println(a + ", " + b);
    }
}

public class MethodOverride {
    public static void main(String[] args) {
        Child o = new Child(10, 20);
        o.show();
        Base b1 = new Base(30);
        b1.show(); 
        Base b2 = o;
        b2.show(); // will call show of Override
        
    }
}
