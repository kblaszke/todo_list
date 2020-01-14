package pl.blaszak.ImportandUrgent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import pl.blaszak.ImportandUrgent.model.Settings;
import pl.blaszak.ImportandUrgent.service.SettingsService;

import javax.validation.Valid;

@Controller
public class SettingsController {

    private static final String SETTINGS_NAME = "settings";


    private final SettingsService settingsService;

    public SettingsController(SettingsService settingsService) {
        this.settingsService = settingsService;
    }

    @GetMapping("/settings")
    public String showSettings(Model model) {
        Settings settings = settingsService.get();
        model.addAttribute(SETTINGS_NAME, settings);
        return "settings";
    }

    @PostMapping("/settings")
    public RedirectView saveSettings(@Valid Settings settings) {
        settingsService.saveAsNew(settings);
        return new RedirectView("/");
    }
}
