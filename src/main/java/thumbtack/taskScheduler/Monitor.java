package thumbtack.taskScheduler;

public class Monitor implements Runnable {

    private TaskScheduler taskScheduler;

    public Monitor(TaskScheduler taskScheduler) {
        this.taskScheduler = taskScheduler;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {

            }
            Task cur = taskScheduler.getTask();
            while (cur != null && cur.time < System.currentTimeMillis()) {
                taskScheduler.removeTask(cur);
                new Thread(cur.callback).start();
                cur = taskScheduler.getTask();
            }
        }
    }
}
