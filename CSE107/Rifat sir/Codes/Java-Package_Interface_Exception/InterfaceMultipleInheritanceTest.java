interface Alpha 
{
    default void reset() {
        System.out.println("Alpha's reset");
    }
}

interface Beta //extends Alpha
{
    default void reset() {
        System.out.println("Beta's reset");
    }
}
public class InterfaceMultipleInheritanceTest implements Alpha, Beta {

    public void reset() {
        System.out.println("My reset");
    }

    public static void main(String[] args) {
        InterfaceMultipleInheritanceTest i = new InterfaceMultipleInheritanceTest();
        i.reset();
    }
}
