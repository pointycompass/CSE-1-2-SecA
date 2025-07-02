package p2;

import p1.Protection;

public class Protection2 extends Protection {
    Protection2() {
        System.out.println("---Protection2---");
        //System.out.println(n); // n is not public in p1.Protection, can't be accessed from outside package
        System.out.println(nProtected);
        System.out.println(nPublic);
        //System.out.println(nPrivate); //nPrivate has private access in p1.Protection
    }
}
