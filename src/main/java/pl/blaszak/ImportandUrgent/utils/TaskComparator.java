package pl.blaszak.ImportandUrgent.utils;

import pl.blaszak.ImportandUrgent.model.Task;

import java.util.Comparator;

public class TaskComparator implements Comparator<Task> {

    private final Float importantFactor;
    private final Float urgentFactor;

    public TaskComparator(Float importantFactor, Float urgentFactor) {
        this.importantFactor = importantFactor;
        this.urgentFactor = urgentFactor;
    }

    @Override
    public int compare(Task task1, Task task2) {
        return costFunction(task2).compareTo(costFunction(task1));
    }

    private Float costFunction(Task task) {
        return importantFactor * pow(task.getImportant()) + urgentFactor * pow(task.getUrgent());
    }

    private static Float pow(Float number) {
        return number * abs(number);
    }

    private static Float abs(Float number) {
        return number < 0.0 ? -1F * number : number;
    }
}
