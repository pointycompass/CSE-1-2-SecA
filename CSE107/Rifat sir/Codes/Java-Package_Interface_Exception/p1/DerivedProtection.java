package p1;

public class DerivedProtection extends Protection {
    DerivedProtection() {
        System.out.println("---DerivedProtection---");
        System.out.println(n);
        //System.out.println(nPrivate); //nPrivate has private access in p1.Protection
        System.out.println(nProtected);
        System.out.println(nPublic);
    }
}
