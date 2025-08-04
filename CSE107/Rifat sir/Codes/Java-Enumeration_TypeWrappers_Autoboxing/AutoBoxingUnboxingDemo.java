public class AutoBoxingUnboxingDemo {

    static int m(Integer v) {
        return v ; // auto-unbox to int
    }

    public static void main(String args[]) {
        // Pass an int to m() and assign the return value
        // to an Integer.  Here, the argument 100 is autoboxed
        // into an Integer.  The return value is also autoboxed
        // into an Integer.
        Integer a  = m(100);
        System.out.println(a);

        Integer iOb, iOb2;
        int i;
        iOb = 100;
        System.out.println("Original value of iOb: " + iOb);
        // The following automatically unboxes iOb,
        // performs the increment, and then reboxes
        // the result back into iOb.
        ++iOb;
        System.out.println("After ++iOb: " + iOb);
        // Here, iOb is unboxed, the expression is
        // evaluated, and the result is reboxed and
        // assigned to iOb2.
        iOb2 = iOb + (iOb / 3);
        System.out.println("iOb2 after expression: " + iOb2);
        // The same expression is evaluated, but the
        // result is not reboxed.
        i = iOb + (iOb / 3);
        System.out.println("i after expression: " + i);

        Integer intOb = 100;
        Double doubleOb = 98.6;
        // Auto-unboxing also allows you to mix different types of
        // numeric objects in an expression. Once the values are unboxed,
        // the standard type promotions and conversions are applied.
        doubleOb = doubleOb + intOb;
        System.out.println("dOb after expression: " + doubleOb);
    }
}