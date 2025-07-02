public class ExceptionUncaught {
    public static void main(String args[]) {
        int a = 10, b = 1;
        int c = a / b; // ArithmeticException: / by zero
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        String s = null;
        System.out.println(s.length()); // NullPointerException
    }
}	
