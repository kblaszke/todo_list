package pl.blaszak.ImportandUrgent.service.dbRepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.blaszak.ImportandUrgent.model.Settings;

public interface SettingsRepository extends MongoRepository<Settings, String> {
}
