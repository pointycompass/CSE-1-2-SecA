class P {
    void call() {
        System.out.println("Inside P's call method");
    }
}

class Q extends P {
    void call() {
        System.out.println("Inside Q's call method");
    }
}

class R extends Q {
    void call() {
        System.out.println("Inside R's call method");
    }
}

public class DynamicDispatchTest {
    public static void main(String[] args) {
        P p = new P(); // object of type P
        Q q = new Q(); // object of type Q
        R r = new R(); // object of type R
        P x; // reference of type P
        x = p; // x refers to a P object
        x.call(); // invoke P's call
        x = q; // x refers to a Q object
        x.call(); // invoke Q's call
        x = r; // x refers to a R object
        x.call(); // invoke R's call
    }
}
