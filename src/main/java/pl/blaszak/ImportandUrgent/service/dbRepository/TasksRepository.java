package pl.blaszak.ImportandUrgent.service.dbRepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.blaszak.ImportandUrgent.model.Task;

public interface TasksRepository  extends MongoRepository<Task, String> {
}
