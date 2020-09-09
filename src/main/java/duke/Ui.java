package duke;

import java.util.ArrayList;

/**
 * Prints the relevant messages.
 */
public class Ui {
    private static final String DIVIDER = "--------------------------------------------------------";
    private static final String DIVIDER_HELP = "********************************************";

    /**
     * Prints and returns logo "Welcome" greeting.
     *
     * @return System reply message.
     */
    public static String getLogoMsg() {
        String logo = "\n\n\n|^_^|┛\nWELCOME to DukeBT!\n";
        System.out.println(logo);
        return logo;
    }

    /**
     * Prints and returns greeting.
     *
     * @return System reply message.
     */
    public static String getGreetingMsg() {
        String greetingMsg = DIVIDER
                + "\n Hello! I'm DukeBT."
                + "\n What can I do for you?"
                + "\n\n **Type 'help' to see what I can do. |^_^|"
                + "\n" + DIVIDER + "\n";
        System.out.println(greetingMsg);
        return greetingMsg;
    }

    /**
     * Prints and returns help message to show all possible commands available.
     *
     * @return System reply message.
     */
    public static String getHelpMsg() {
        String commandList = DIVIDER_HELP
                + " ┗( ⊙.⊙ )┛ "
                + "\n These are all the commands you may use:"
                + "\n     1.list -- show all tasks"
                + "\n     2.todo <task name> -- add a task"
                + "\n     3.deadline <task name> /by <task deadline> -- add a task with its deadline"
                + "\n     4.event <event name> /at <event timing> -- add an event with its timing"
                + "\n     5.done <task index> -- mark this task as done"
                + "\n     6.delete <task index> -- mark this task from task list"
                + "\n     7.find <keyword> -- find all tasks in the task list which contains the keyword"
                + "\n     8.help -- show all commands"
                + "\n     9.bye -- exit the chatbot"
                + "\n" + DIVIDER_HELP + "\n";
        System.out.println(commandList);
        return commandList;
    }

    /**
     * Prints and returns bye message to see goodbye to the user.
     *
     * @return System reply message.
     */
    public static String getByeMsg() {
        String byeMsg = DIVIDER
                + "\n |^_^|┛"
                + "\n Bye. Hope to see you again soon!"
                + "\n Your task list has been saved."
                + "\n It will be automatically reloaded when you come back!"
                + "\n" + DIVIDER + "\n";
        System.out.println(byeMsg);
        return byeMsg;
    }

    /**
     * Prints and returns confirmation message to show user
     * the deadline task has been added into the task list.
     *
     * @param tasks The overall user's task list.
     * @return System reply message.
     */
    public static String getAddingDeadlineTaskMsg(ArrayList<Task> tasks) {
        String outputMsg = DIVIDER
                + "\n (^.^)"
                + "\n Got it. I've added this Deadline task:"
                + "\n     " + tasks.size() + "." + tasks.get(tasks.size() - 1)
                + "\n Now you have " + tasks.size() + " tasks in the list."
                + "\n" + DIVIDER + "\n";
        System.out.println(outputMsg);
        return outputMsg;
    }

    /**
     * Prints and returns confirmation message to show user
     * the event task has been added into the task list.
     *
     * @param tasks The overall user's task list.
     * @return System reply message.
     */
    public static String getAddingEventTaskMsg(ArrayList<Task> tasks) {
        String outputMsg = DIVIDER
                + "\n (^.^)"
                + "\n Got it. I've added this Event task:"
                + "\n     " + tasks.size() + "." + tasks.get(tasks.size() - 1)
                + "\n Now you have " + tasks.size() + " tasks in the list."
                + "\n" + DIVIDER + "\n";
        System.out.println(outputMsg);
        return outputMsg;
    }

    /**
     * Prints and returns confirmation message to show user
     * the to-do task has been added into the task list.
     *
     * @param tasks The overall user's task list.
     * @return System reply message.
     */
    public static String getAddingTodoTaskMsg(ArrayList<Task> tasks) {
        String outputMsg = DIVIDER
                + "\n (^.^)"
                + "\n Got it. I've added this ToDo task:"
                + "\n     " + tasks.size() + "." + tasks.get(tasks.size() - 1)
                + "\n Now you have " + tasks.size() + " tasks in the list."
                + "\n" + DIVIDER + "\n";
        System.out.println(outputMsg);
        return outputMsg;
    }

    /**
     * Prints and returns confirmation message to show user
     * the task task has been marked as done.
     *
     * @param index A series number of the task in the task list.
     * @param tasks The overall user's task list.
     * @return System reply message.
     */
    public static String getDoneTaskMsg(int index, ArrayList<Task> tasks) {
        String outputMsg = DIVIDER
                + "\n (ﾉﾟ0ﾟ)ﾉ~"
                + "\n Congratulations from DukeBT! You have done 1 task!"
                + "\n The task below has been marked as done:"
                + "\n      Task #" + index + ". " + tasks.get(index - 1)
                + "\n" + DIVIDER + "\n";
        System.out.println(outputMsg);
        return outputMsg;
    }

    /**
     * Prints and returns confirmation message to show user
     * the corresponding task has been deleted from the task list.
     *
     * @param index        A series number of the task in the task list.
     * @param taskToDelete Task to be deleted.
     * @param tasks        The overall user's task list.
     * @return System reply message.
     */
    public static String getDeleteTaskMsg(int index, Task taskToDelete, TaskList tasks) {
        String outputMsg = DIVIDER
                + "\n (ಠ‿↼)"
                + "\n Noted. This task has been removed from your task list:"
                + "\n      Task #" + index + ". " + taskToDelete
                + "\n Now you have " + tasks.getTaskListSize() + " tasks in the list."
                + "\n" + DIVIDER + "\n";
        System.out.println(outputMsg);
        return outputMsg;
    }

    /**
     * Prints and returns out all tasks stored in the task list.
     *
     * @param tasks The overall user's task list.
     * @return System reply message.
     */
    public static String getAllTasksMsg(ArrayList<Task> tasks) {
        String outputMsg = "";
        if (tasks.isEmpty()) {
            outputMsg = DIVIDER
                    + "\n (⊙ ‿ ⊙)"
                    + "\n Task list is empty, please try to add some tasks first."
                    + "\n" + DIVIDER + "\n";
            System.out.println(outputMsg);
            return outputMsg;
        }

        outputMsg = DIVIDER
                + "\n (⊙ ‿ ⊙)"
                + "\n You have " + tasks.size() + " tasks in total."
                + "\n Here they are:";
        return getAllTasks(tasks, outputMsg);
    }

    /**
     * Prints and returns out all tasks that match the keyword stored in the task list.
     *
     * @param keyword      A string of keyword to find the matching tasks.
     * @param matchedTasks An ArrayList of all the tasks that match with the keyword.
     * @return System reply message.
     */
    public static String getMatchingTasksMsg(String keyword, ArrayList<Task> matchedTasks) {
        String outputMsg = "";
        if (matchedTasks.isEmpty()) {
            outputMsg = DIVIDER
                    + "\n (⊙ ‿ ⊙)"
                    + "\n There is no matching task with the keyword - '" + keyword + "'."
                    + "\n" + DIVIDER + "\n";
            System.out.println(outputMsg);
            return outputMsg;
        }

        outputMsg = DIVIDER
                + "\n (⊙ ‿ ⊙)"
                + "\n You have " + matchedTasks.size() + " tasks matched with keyword - '"
                + keyword + "'."
                + "\n Here they are:";
        return getAllTasks(matchedTasks, outputMsg);
    }

    private static String getAllTasks(ArrayList<Task> taskList, String outputMsg) {
        for (int i = 0; i < taskList.size(); i++) {
            outputMsg += "\n      " + (i + 1) + ". " + taskList.get(i);
        }
        outputMsg += "\n" + DIVIDER + "\n";

        System.out.println(outputMsg);
        return outputMsg;
    }
}
