package thumbtack.taskScheduler;

import java.util.*;

public class TaskScheduler {

    private final TreeSet<Task> tasks = new TreeSet<>();

    public void addTask(String content, long time) {
        Task newTask = new Task(content, time);
        synchronized (this) {
            if (tasks.isEmpty()) {
                notifyAll();
            }
            tasks.add(newTask);
        }
    }

    public synchronized Task getTask() {
        while (tasks.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException ie) {

            }
        }
        return tasks.first();
    }

    public synchronized boolean removeTask(Task task) {
        return this.tasks.remove(task);
    }

    public synchronized boolean isEmpty() {
        return tasks.isEmpty();
    }

    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        Monitor monitor = new Monitor(scheduler);
        scheduler.addTask("task1", System.currentTimeMillis() - 1000);
        scheduler.addTask("task2", System.currentTimeMillis() - 2000);
        scheduler.addTask("task3", System.currentTimeMillis() - 3000);
        scheduler.addTask("task4", System.currentTimeMillis() + 1000);
        scheduler.addTask("task5", System.currentTimeMillis() + 2000);
        Thread monitorThread = new Thread(monitor);
        monitorThread.start();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException ie) {

        }
        System.out.println("add new task");
        scheduler.addTask("task5", System.currentTimeMillis() + 4000);
    }
}
