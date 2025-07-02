package synchronization;

class SharedCounter {
    private int counter;

    SharedCounter() {
        this.counter = 0;
    }

    public void increment() {
        this.counter++;        
    }

    public int get() {
        return this.counter;
    }

     void count() {
        for (int i = 0; i < 10000; i++) {
            increment();
        }
    }

}

class ThreadCounterNoSync implements Runnable {
    SharedCounter sharedCounter;
    Thread t;

    public ThreadCounterNoSync(SharedCounter s, String name) {
        sharedCounter = s;
        t = new Thread(this, name);
        t.start();
    }

    public void run() {
        sharedCounter.count();
    }

    public static void main(String[] args) {
        SharedCounter sharedCounter = new SharedCounter();
        sharedCounter.count();
        System.out.println(sharedCounter.get());
    }
}

public class NonSynchronizedCounter {
    public static void main(String[] args) {
        SharedCounter sharedCounter = new SharedCounter();
        ThreadCounterNoSync ob1 = new ThreadCounterNoSync(sharedCounter, "T1");
        ThreadCounterNoSync ob2 = new ThreadCounterNoSync(sharedCounter, "T1");
        // ThreadCounterNoSync ob3 = new ThreadCounterNoSync(sharedCounter, "T1");
        try {
            ob1.t.join();
            ob2.t.join();
            // ob3.t.join();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(sharedCounter.get());
    }
}
