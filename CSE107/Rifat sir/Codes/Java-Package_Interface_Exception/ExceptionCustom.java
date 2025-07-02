class MyException extends Exception {
    private int detail;
    MyException(int a) {
        detail = a;
    }
    @Override
    public String toString() {
        return "My Exception :  " + detail;
    }
}

public class ExceptionCustom {
    static void compute(int a) throws MyException {
        if (a > 10) {
            throw new MyException(a);
        }
        System.out.println(a);
    }
    public static void main(String args[]) {
        try {
            compute(10);
            compute(20);
        } catch (MyException e) {
            System.out.println(e);
        }
    }
}