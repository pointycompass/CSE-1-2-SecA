public class A {
    private int a;

    public A()
    {
        System.out.println("In Constructor");
        this.a = 0;
    }

    public void setA(int a)
    {
        this.a = a;
    }

    public int getA()
    {
        return this.a;
    }

    public static void main(String args[])
    {
        A ob;
        ob = new A();
        // A ob = new A() is same as before but in a single statement
        // new A() is also fine but unnecessary object creation       
        ob.setA(10);
        System.out.println(ob.getA());        
    }
}

