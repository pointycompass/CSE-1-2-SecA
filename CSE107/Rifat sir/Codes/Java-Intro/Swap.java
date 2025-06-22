class MyInt 
{
    int a;
}

class Swap {
    public static void main(String[] args) {
        int a = 10, b= 20;
        System.out.println("a = " + a + ", b = " + b);
        swap1(a,b);
        System.out.println("a = " + a + ", b = " + b);
        Integer x = 10, y = 20;
        System.out.println("x = " + a + ", y = " + b);
        swap2(x,y);
        System.out.println("x = " + a + ", y = " + b);
        MyInt m = new MyInt();
        m.a = 10;
        MyInt n = new MyInt();
        n.a = 20;
        System.out.println("x = " + m.a + ", y = " + n.a);
        swap3(m,n);
        System.out.println("x = " + m.a + ", y = " + n.a);
        int [] aa = new int[1];
        int [] bb = new int[1];
        aa[0] = 10;
        bb[0] = 20;
        System.out.println("x = " + aa[0] + ", y = " + bb[0]);
        swap4(aa, bb);
        System.out.println("x = " + aa[0] + ", y = " + bb[0]);
    }

    static void swap1(int a, int b) {
        int c = a;
        a = b;
        b = c;
    }

    static void swap2(Integer a, Integer b) {
        Integer c = a;
        a = b;
        b = c;
    }

    static void swap3(MyInt x, MyInt y) {
        int c = x.a;
        x.a = y.a;
        y.a = c;
    }

    static void swap4(int [] x, int [] y) {
        int c = x[0];
        x[0] = y[0];
        y[0] = c;
    }
}