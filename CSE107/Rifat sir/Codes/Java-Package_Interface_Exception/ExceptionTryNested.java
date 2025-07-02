import java.util.Random;

public class ExceptionTryNested {
    public static void main(String args[]) {
        int a = 10, b, c;
        Random r = new Random();
        try {
            for (int i = 1; i <= 32000; i++)
                try {
                    b = r.nextInt();
                    c = r.nextInt();
                    a = 12345 / (b / c);
                } catch (ArithmeticException e) {
                    System.out.println(e);
                    a = 0;
                } finally {
                    System.out.println(i + ": " + a);
                }
        } catch (ArithmeticException e) {
            System.out.println(e);
        }
    }
}
	