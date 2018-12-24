package thumbtack.taskScheduler;

public class Callback implements Runnable {

    private final String message;
    public Callback(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        utils.Display.threadMessage("executing " + message);
    }
}
