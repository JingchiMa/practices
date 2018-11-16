package multithreads.producerConsumer;

public class TestProducerConsumer {

    public static void main(String[] args) {
        SharedQueue sharedQueue = new SharedQueue();
        Thread producer = new Thread(new Producer(sharedQueue));
        Thread consumer = new Thread(new Consumer(sharedQueue));

        producer.start();
        consumer.start();
    }
}
