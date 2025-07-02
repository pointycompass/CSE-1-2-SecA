package advanced;

class BufferC {
    int value;
    boolean valueSet = false;

    synchronized int consume() {
        // System.out.println(Thread.currentThread().getName() + " enters");
        while (!valueSet) { // always use while instead of if
            try {
                // System.out.println(Thread.currentThread().getName() + " waits");
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        }
        System.out.println(Thread.currentThread().getName() + " consumes: " + value);
        valueSet = false;
        notifyAll(); // always use notifyAll instead of notify
        // System.out.println(Thread.currentThread().getName() + " exists");
        return value;
    }

    synchronized void produce(int value) {
        // System.out.println(Thread.currentThread().getName() + " enters");
        while (valueSet) { // always use while instead of if
            try {
                // System.out.println(Thread.currentThread().getName() + " waits");
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        }
        this.value = value;
        valueSet = true;
        System.out.println(Thread.currentThread().getName() + " produces: " + this.value);
        notifyAll(); // always use notifyAll instead of notify
        // System.out.println(Thread.currentThread().getName() + " exists");
    }
}

class ProducerC implements Runnable {
    BufferC buffer;

    ProducerC(BufferC buffer, String name) {
        this.buffer = buffer;
        new Thread(this, name).start();
    }

    public void run() {
        int i = 0;
        while (i < 100) {
            buffer.produce(i++);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class ConsumerC implements Runnable {
    BufferC buffer;

    ConsumerC(BufferC buffer, String name) {
        this.buffer = buffer;
        new Thread(this, name).start();
    }

    public void run() {
        int i = 0;
        while (i++ < 100) {
            buffer.consume();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class CorrectPC {
    public static void main(String[] args) {
        BufferC buffer = new BufferC();
        new ProducerC(buffer, "Producer");
        new ConsumerC(buffer, "Consumer");
        // new ConsumerC(buffer, "Consumer-2");
        System.out.println("Press Control-advanced.C to stop.");
    }
}