package advanced;

class PollingBuffer {
    int value;
    volatile boolean valueSet = false;

    void consume() {
        while (!valueSet) {

        }
        valueSet = false;
        System.out.println(Thread.currentThread().getName() + " consumes: " + value);
    }

    void produce(int value) {
        while (valueSet) {

        }
        this.value = value;
        this.valueSet = true;
        System.out.println(Thread.currentThread().getName() + " produces: " + this.value);
    }
}

class PollingProducer implements Runnable {
    PollingBuffer buffer;

    PollingProducer(PollingBuffer buffer, String name) {
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

class PollingConsumer implements Runnable {
    PollingBuffer buffer;

    PollingConsumer(PollingBuffer buffer, String name) {
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

public class PollingPC {
    public static void main(String[] args) {
        PollingBuffer buffer = new PollingBuffer();
        new PollingProducer(buffer, "Producer");
        new PollingConsumer(buffer, "Consumer");
        System.out.println("Press Control-advanced.C to stop.");
    }
}
