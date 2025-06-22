class MyClass{
    private int x;
    MyClass() {
        this.x = 0;
    }

    void setX(int x) {
        this.x = x;
    }

    int getX() {
        return x;
    }
}
public class RefVarDemo {
    public static void main(String[] args) {
        var mc = new MyClass();
        System.out.println(mc.getX());
        mc.setX(10);
        System.out.println(mc.getX());
        var str = "Hello World";
        System.out.println(str);
    }
}
