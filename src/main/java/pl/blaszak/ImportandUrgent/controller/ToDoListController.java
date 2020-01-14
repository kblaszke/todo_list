package pl.blaszak.ImportandUrgent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.thymeleaf.util.StringUtils;
import pl.blaszak.ImportandUrgent.model.Task;
import pl.blaszak.ImportandUrgent.service.TaskService;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Controller
public class ToDoListController {

    private static final String TODO_LIST_NAME = "tasks";
    private static final String TASK_NAME = "task";
    private static final String ACTION_NAME = "action";

    private final TaskService taskService;
    private final MessageSource messageSource;

    @Autowired
    public ToDoListController(TaskService taskService, MessageSource messageSource) {
        this.taskService = taskService;
        this.messageSource = messageSource;
    }

    @GetMapping("/")
    public String toDoListGet(Model model) {
        List<Task> tasks = taskService.getTasks();
        model.addAttribute(TODO_LIST_NAME, tasks);
        return "toDoList";
    }

    @GetMapping("/editTask/{id}")
    public String editTaskGet(@PathVariable("id") String id, Model model, Locale locale) {
        model.addAttribute(ACTION_NAME, getEditActionName(locale));
        return editTaskGet(taskService.findById(id), model);
    }

    @GetMapping("/editTask/")
    public String addTaskGet(Model model, Locale locale) {
        model.addAttribute(ACTION_NAME, getAddActionName(locale));
        return editTaskGet(new Task(), model);
    }

    private String editTaskGet(Task task, Model model) {
        model.addAttribute(TASK_NAME, task);
        return "editTask";
    }

    @GetMapping("/deleteTask/{id}")
    public RedirectView deleteTask(@PathVariable("id") String id){
        taskService.delete(id);
        return new RedirectView("/");
    }

    @PostMapping("/saveTask")
    public ModelAndView saveTask(@Valid Task task, BindingResult bindingResult, Locale locale) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("editTask");
            modelAndView.getModel().put(TASK_NAME, task);
            if (StringUtils.isEmpty(task.getId())) {
                modelAndView.getModel().put(ACTION_NAME, getAddActionName(locale));
            } else {

            }
            modelAndView.getModel().put(ACTION_NAME, getEditActionName(locale));
            return modelAndView;
        } else {
            modelAndView.setViewName("redirect:/");
            taskService.save(task);
        }
        return modelAndView;
    }

    private String getAddActionName(Locale locale) {
        return messageSource.getMessage("editTask.addTask", null, locale);
    }

    private String getEditActionName(Locale locale) {
        return messageSource.getMessage("editTask.editTask", null, locale);
    }

}
