package multithreads;

public class HelloRunnable implements Runnable {
    static String importantInfo[] = {
            "Mares eat oats",
            "Does eat oats",
            "Little lambs eat ivy",
            "A kid will eat ivy too"
    };

    @Override
    public void run() {
//        for (String info : importantInfo) {
//            System.out.println(info);
////            try {
////                Thread.sleep(1000);
////            } catch (InterruptedException ie) {
////                System.out.println("I'm Interrupted!! WTH");
////            }
//        }
        for (int i = 0; i < 10000000; i++) {

        }


    }

    public static void main(String[] args) throws InterruptedException {
         Thread thread = new Thread(new HelloRunnable());
         thread.start();
         // System.out.println("I'm gonna interrupt the thread");
         thread.interrupt();
         System.out.println(thread.isInterrupted());
    }
}
