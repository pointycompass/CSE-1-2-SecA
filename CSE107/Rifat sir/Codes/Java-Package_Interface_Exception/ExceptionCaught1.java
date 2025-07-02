public class ExceptionCaught1 {
    public static void main(String args[]) {
        int a = 10, b = 0, c = 0;
        try {
            // try requires at least one catch or a finally clause
            c = a / b;
            System.out.println("This will never print");
        }
        catch (Exception e) { // ArithmeticException
            System.out.println("In Catch");
            System.out.println(e);
        }
        finally {
            // finally block is optional
            // finally block will always execute
            System.out.println("In Finally");
        }
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
	