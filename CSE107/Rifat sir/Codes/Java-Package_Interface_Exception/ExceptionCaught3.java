import java.util.Random;

public class ExceptionCaught3 {
    public static void main(String args[]) {
        int a = 10, b, c;
        Random r = new Random();
        /*for (int i = 1; i <= 32000; i++) {
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
        }*/
        try {
            for (int i = 1; i <= 32000; i++) {
                b = r.nextInt();
                c = r.nextInt();
                a = 12345 / (b / c);
                System.out.println(a);
            }
        } catch(Exception e) {
            System.out.println(0);
            System.out.println(e);
        }
    }
}
	