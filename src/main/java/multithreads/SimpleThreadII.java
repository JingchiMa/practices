package multithreads;

public class SimpleThreadII {

    static void threadMessage(String message) {
        String threadName =
                Thread.currentThread().getName();
        System.out.format("%s: %s%n",
                threadName,
                message);
    }

    static class TellingStories implements Runnable {
        @Override
        public void run() {
            String story[] = {
                    "Mares eat oats",
                    "Does eat oats",
                    "Little lambs eat ivy",
                    "A kid will eat ivy too"
            };
            for (String sentence : story) {
                threadMessage(sentence);
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException ie) {
                    threadMessage("I wasn't done yet! I won't stop");
                }
            }
        }
    }

    public static void main(String[] args) {
        int patience = 1000 * 10; // 10 seconds
        Thread thread = new Thread(new TellingStories());
        long startTime = System.currentTimeMillis();
        thread.start();
        while (thread.isAlive()) {
            threadMessage("Still waiting...");
            try {
                thread.join(1000);
                if (thread.isAlive() && System.currentTimeMillis() - startTime > patience) {
                    threadMessage("Enough!");
                    thread.interrupt();
                    thread.join();
                }
            } catch (InterruptedException ie) {
                threadMessage("What? I'm interrupted");
            }
        }
        threadMessage("It finally done");
    }
}
