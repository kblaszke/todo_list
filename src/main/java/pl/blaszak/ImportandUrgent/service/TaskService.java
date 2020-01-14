package pl.blaszak.ImportandUrgent.service;

import org.springframework.util.CollectionUtils;
import pl.blaszak.ImportandUrgent.model.Task;
import pl.blaszak.ImportandUrgent.service.dbRepository.TasksRepository;
import pl.blaszak.ImportandUrgent.utils.TaskComparator;

import java.util.List;
import java.util.stream.Collectors;

public class TaskService {

    private final TasksRepository repository;
    private final TaskComparator comparator;

    public TaskService(TasksRepository repository, TaskComparator comparator) {
        this.repository = repository;
        this.comparator = comparator;
    }

    public List<Task> getTasks() {
        List<Task> tasks = repository.findAll().stream().sorted(comparator).collect(Collectors.toList());
        return CollectionUtils.isEmpty(tasks) ? null : tasks;
    }

    public boolean save(Task task) {
        return repository.save(task) != null;
    }

    public Task findById(String id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(String id) {
        repository.findById(id).ifPresent(task -> repository.delete(task));
    }
}
