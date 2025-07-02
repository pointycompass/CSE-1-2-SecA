package synchronization;

class SharedCounter2 {
    private int counter;

    SharedCounter2() {
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

class ThreadCounterSyncBlock implements Runnable {
    SharedCounter2 sharedCounter;
    Thread t;

    public ThreadCounterSyncBlock(SharedCounter2 s, String name) {
        sharedCounter = s;
        t = new Thread(this, name);
        t.start();
    }

    public void run() {
        synchronized(this) {
         sharedCounter.count();
        }
    }
}

public class SynchronizedCounterBlock {
    public static void main(String[] args) {
        SharedCounter2 sharedCounter = new SharedCounter2();
        ThreadCounterSyncBlock ob1 = new ThreadCounterSyncBlock(sharedCounter, "T1");
        ThreadCounterSyncBlock ob2 = new ThreadCounterSyncBlock(sharedCounter, "T2");
        ThreadCounterSyncBlock ob3 = new ThreadCounterSyncBlock(sharedCounter, "T3");
        try {
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(sharedCounter.get());
    }
}
