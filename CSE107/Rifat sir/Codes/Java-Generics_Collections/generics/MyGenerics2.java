package generics;

public class MyGenerics2<S, T> {
    private S a;
    private T b;

    public MyGenerics2(S a, T b) {
        this.a = a;
        this.b = b;
    }

    public S getObj1() {
        return this.a;
    }

    public T getObj2() {
        return this.b;
    }

    public static void main(String[] args) {
        MyGenerics2<Integer, String> myGenerics = new MyGenerics2<>(10, "Hello");
        System.out.println(myGenerics.getObj1());
        System.out.println(myGenerics.getObj2());
    }
}


