public class ExceptionThrows {
    public static void f() throws IllegalAccessException {
        System.out.println("In f()");
        throw new IllegalAccessException("f");
    }

    public static void main(String args[])  {
        try {
            f();
        } catch (IllegalAccessException e) {
            System.out.println("Inside catch of main()");
            e.printStackTrace();
        }
    }
}
	