package generics;

class GenCons {
    private double val;

    public <T extends Number> GenCons(T arg) {
        val = arg.doubleValue();
    }

    void showVal() {
        System.out.println("val: " + val);
    }

    public static <V> boolean isIn(V x, V[] a) {
        for (V t : a) {
            if (t == x) return true;
        }
        return false;
    }

    public <V> boolean isIn2(V x, V[] a) {
        for (V t : a) {
            if (t == x) return true;
        }
        return false;
    }
}

public class MyGenerics4 {
    public static void main(String args[]) {
        GenCons test = new <Integer>GenCons(100);
        GenCons test2 = new GenCons(123.5d);
        test.showVal();
        test2.showVal();
        Integer [] iArray = {1, 2, 3, 4, 5};
        System.out.println(GenCons.<Integer>isIn(1, iArray));
        System.out.println(test.<Integer>isIn2(1, iArray));
    }
}