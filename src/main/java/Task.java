import java.util.ArrayList;

public class Task {
    private String taskTitle;
    private boolean isDone;

    public Task(String taskTitle) {
        this.taskTitle = taskTitle;
        this.isDone = false;
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public String getStatus() {
        return (isDone ? "✓" : "✗");
    }

    public static void doneTask(int index, ArrayList<Task> tasks) {
        tasks.get(index - 1).markAsDone();
        Feedbacks.doneTaskMsg(index, tasks);
    }

    public static void deleteTask(int index, ArrayList<Task> tasks) {
        Task taskToDelete = tasks.get(index - 1);
        tasks.remove(index - 1);
        int newSizeOfTasks = tasks.size();
        Feedbacks.deleteTaskMsg(index, newSizeOfTasks, taskToDelete);
    }

    @Override
    public String toString() {
        return "[" + getStatus() + "] " + taskTitle;
    }
}
