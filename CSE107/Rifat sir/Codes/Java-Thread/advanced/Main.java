package advanced;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class P implements Runnable {

    private final BlockingQueue<Integer> queue;
    private final Integer POISON;

    @Override
    public void run() {

        try {
            process();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            while (true) {
                try {
                    queue.put(POISON);
                    queue.put(POISON);
                    break;
                } catch (InterruptedException e) {
                    // ...
                }
            }
        }

    }

    private void process() throws InterruptedException {

        // Put 20 elements into Queue
        for (int i = 0; i < 20; i++) {
            System.out.println("[Producer] Put : " + i);
            queue.put(i);
            System.out.println("[Producer] Queue remainingCapacity : " + queue.remainingCapacity());
            Thread.sleep(100);
        }

    }

    public P(BlockingQueue<Integer> queue, Integer POISON) {
        this.queue = queue;
        this.POISON = POISON;
    }

}

class C implements Runnable {

    private final BlockingQueue<Integer> queue;
    private final Integer POISON;

    @Override
    public void run() {

        try {
            while (true) {
                Integer take = queue.take();
                process(take);

                // if this is a poison pill, break, exit
                if (take == POISON) {
                    break;
                }

            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }

    private void process(Integer take) throws InterruptedException {
        System.out.println("[Consumer] Take : " + take);
        Thread.sleep(500);
    }

    public C(BlockingQueue<Integer> queue, Integer POISON) {
        this.queue = queue;
        this.POISON = POISON;
    }
}

public class Main {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(1);

        // new Thread(new Producer(queue)).start();
        // new Thread(new Consumer(queue)).start();

        Integer poison = -1;
        new Thread(new P(queue, poison)).start();
        // new Thread(new advanced.P(queue, poison)).start();

        new Thread(new C(queue, poison)).start();
        new Thread(new C(queue, poison)).start();
    }
}
