package pl.blaszak.ImportandUrgent;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.blaszak.ImportandUrgent.service.SettingsService;
import pl.blaszak.ImportandUrgent.service.TaskService;
import pl.blaszak.ImportandUrgent.service.dbRepository.SettingsRepository;
import pl.blaszak.ImportandUrgent.service.dbRepository.TasksRepository;
import pl.blaszak.ImportandUrgent.utils.TaskComparator;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public TaskService createTaskService(TasksRepository repository, TaskComparator comparator) {
        return new TaskService(repository, comparator);
    }

    @Bean
    public TaskComparator createTaskComparator() {
        return new TaskComparator(1F, 1F);
    }

    @Bean
    public SettingsService createSettingsService(SettingsRepository repository) {
        return new SettingsService(repository);
    }

}
