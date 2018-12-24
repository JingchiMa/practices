package thumbtack.taskScheduler;

public class Task implements Comparable<Task> {
    String content;
    long time;
    boolean done;
    Callback callback;

    public Task(String content, long time) {
        this.content = content;
        this.time = time;
        done = false; // todo: deal with invalid input time
        this.callback = new Callback(content);
    }

    @Override
    public int compareTo(Task another) {
        if (this.time == another.time) {
            return 0;
        }
        return this.time < another.time ? -1 : 1;
    }

}
