package multithreads.producerConsumer;

import java.util.ArrayDeque;
import java.util.Queue;

import static utils.Display.threadMessage;

public class SharedQueue {
    private Queue<Integer> queue = new ArrayDeque<>();
    private final int capacity = 5;

    public SharedQueue() {

    }

    public synchronized void put(int num) {
        if (queue.isEmpty()) {
            this.notifyAll(); // change status for consumer
        }
        while (queue.size() == capacity) {
            threadMessage("Can't put");
            try {
                this.wait();
            } catch (InterruptedException ie) {

            }
        }
        queue.offer(num);
        threadMessage("queue size is " + queue.size());
    }

    public synchronized void take() {
        if (queue.size() == capacity) {
            this.notifyAll();
        }
        while (queue.isEmpty()) {
            threadMessage("Can't take");
            try {
                this.wait();
            } catch (InterruptedException ie) {

            }
        }
        threadMessage("Get " + queue.poll());
        threadMessage("queue size is " + queue.size());
    }
}
