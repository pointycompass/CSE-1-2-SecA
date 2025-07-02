package threads;

class NewThread implements Runnable {
    String name; // name of thread
    Thread t;

    NewThread(String threadName) {
        name = threadName;
        t = new Thread(this, name);
        t.start(); // Start the thread
    }

    public void run() {
        System.out.println(name + " starting.");
        try {
            for (int i = 10; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(name + "Interrupted");
        }
        System.out.println(name + " exiting.");
    }
}

public class MultipleThreads {
    public static void main(String[] args) {
        System.out.println("Main thread starting.");

        new NewThread("One");
        new NewThread("Two");
        new NewThread("Three");

        /*try {
            // wait for other threads to end
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }*/

        System.out.println("Main thread exiting.");
    }
}
