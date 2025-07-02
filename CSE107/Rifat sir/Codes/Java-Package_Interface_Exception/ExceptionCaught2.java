public class ExceptionCaught2 {
    public static void main(String args[]) {
        int a = 10, b = 0, c;
        try {
            c = a / b;
            System.out.println("This will never print");
        } catch (Exception e) { // ArithmeticException
            System.out.println("In Catch");
            System.out.println(e);
            return;
        } finally {
            // finally block will always execute
            System.out.println("In Finally");
        }
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
	