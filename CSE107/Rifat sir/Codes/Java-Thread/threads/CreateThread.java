package threads;

public class CreateThread  {
    public static void main(String[] args) {
        CreateThread ct = new CreateThread();
        new Thread(ct::f1, "T1").start();
        new Thread(CreateThread::f2, "T3").start();
    }

    public void f1() {
        for (int i = 10; i > 0; i--) {
            System.out.println("f1(): " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public static void f2() {
        for (int i = 10; i > 0; i--) {
            System.out.println("f2(): " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

}
