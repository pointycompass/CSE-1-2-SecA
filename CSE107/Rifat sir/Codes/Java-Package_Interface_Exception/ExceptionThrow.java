public class ExceptionThrow {
    public static void f() {
        try {
            throw new NullPointerException("This is my custom generated exception");
        } catch (Exception e) {
            System.out.println("Inside catch of f()");
            throw e; //rethrow the exception
        }
    }

    public static void main(String args[]) {
        try {
            f();
        } catch (NullPointerException e) {
            System.out.println("Inside catch of main()");
        }
    }
}
	