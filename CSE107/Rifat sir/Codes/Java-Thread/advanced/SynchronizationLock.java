package advanced;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

class SharedClass4 {
    Lock lock = new ReentrantLock();

    void doSomething() {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + " starts");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println(Thread.currentThread().getName() + " finishes");
        lock.unlock();
    }
}

class ThreadSyncLock implements Runnable {
    SharedClass4 sharedClass;
    Thread t;

    public ThreadSyncLock(SharedClass4 s, String name) {
        sharedClass = s;
        t = new Thread(this, name);
        t.start();
    }

    public void run() {
        sharedClass.doSomething();
    }
}

public class SynchronizationLock {
    public static void main(String[] args) {
        SharedClass4 sharedObject = new SharedClass4();
        ThreadSyncLock ob1 = new ThreadSyncLock(sharedObject, "T1");
        ThreadSyncLock ob2 = new ThreadSyncLock(sharedObject, "T2");
        ThreadSyncLock ob3 = new ThreadSyncLock(sharedObject, "T3");
        System.out.println(ob1);
        System.out.println(ob2);
        System.out.println(ob3);
    }
}
