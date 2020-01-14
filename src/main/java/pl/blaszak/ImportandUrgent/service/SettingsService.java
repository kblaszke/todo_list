package pl.blaszak.ImportandUrgent.service;

import org.springframework.util.CollectionUtils;
import pl.blaszak.ImportandUrgent.model.Settings;
import pl.blaszak.ImportandUrgent.service.dbRepository.SettingsRepository;

import java.util.List;

public class SettingsService {

    private final SettingsRepository repository;

    public SettingsService(SettingsRepository repository) {
        this.repository = repository;
    }

    public Settings get() {
        List<Settings> settingsList = repository.findAll();
        return CollectionUtils.isEmpty(settingsList) ? initSettings() : settingsList.get(settingsList.size() - 1);
    }

    private Settings initSettings() {
        Settings settings = new Settings();
        settings.setImportantFactor(1F);
        settings.setUrgentFactor(1F);
        return settings;
    }

    public void saveAsNew(Settings settings) {
        repository.save(cloneSettingsAsNew(settings));
    }

    private Settings cloneSettingsAsNew(Settings settings) {
        if (settings.getId() == null) {
            return settings;
        }
        Settings newSettings = new Settings();
        newSettings.setUrgentFactor(settings.getUrgentFactor());
        newSettings.setImportantFactor(settings.getImportantFactor());
        return newSettings;
    }
}
