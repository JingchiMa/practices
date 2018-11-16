package multithreads.producerConsumer;

import java.util.Queue;

public class Producer implements Runnable {

    private SharedQueue sharedQueue;
    private int num = 0;

    public Producer(SharedQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {

            }
            sharedQueue.put(num);
            num++;
        }
    }
}
