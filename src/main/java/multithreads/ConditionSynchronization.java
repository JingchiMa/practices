package multithreads;

public class ConditionSynchronization {

    static void threadMessage(String message) {
        String threadName =
                Thread.currentThread().getName();
        System.out.format("%s: %s%n",
                threadName,
                message);
    }

    private Object object = new Object();
    private boolean shouldWait = true;

    public synchronized void testWait() {
        while (shouldWait) {
            threadMessage("Still wait...");
            try {
                this.wait();
            } catch(InterruptedException ie) {
                threadMessage("Hmmm don't bother me");
            }
            threadMessage("I'm awaken, no need to wait anymore?");
        }
        threadMessage("Yes! No need to wait");
    }

    public synchronized void testNotify() {
        shouldWait = false;
        threadMessage("OK everyone now no needs to wait! Wake up!");
        this.notifyAll();
    }

    public synchronized void fakeNotify() {
        this.notifyAll();
    }

    static class Wait implements Runnable {
        private ConditionSynchronization instance;

        Wait(ConditionSynchronization instance) {
            this.instance = instance;
        }

        @Override
        public void run() {
            instance.testWait();
        }
    }

    static class Notify implements Runnable {
        private ConditionSynchronization instance;

        Notify(ConditionSynchronization instance) {
            this.instance = instance;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException ie) {

            }
            instance.testNotify();
        }
    }

    static class FakeNotify implements Runnable {
        private ConditionSynchronization instance;

        FakeNotify(ConditionSynchronization instance) {
            this.instance = instance;
        }

        @Override
        public void run() {
            for (int i = 0; i < 4; i++) {
                instance.fakeNotify();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ie) {

                }
            }
        }
    }


    public static void main(String[] args) {
        ConditionSynchronization shared = new ConditionSynchronization();
        Thread thread1 = new Thread(new Wait(shared));
        Thread thread2 = new Thread(new Notify(shared));
        // ConditionSynchronization another = new ConditionSynchronization();
        Thread thread3 = new Thread(new FakeNotify(shared));
        thread1.start();
        thread3.start();
        thread2.start();

    }
}
