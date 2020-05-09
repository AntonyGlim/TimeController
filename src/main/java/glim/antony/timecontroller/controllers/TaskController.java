package glim.antony.timecontroller.controllers;

import glim.antony.timecontroller.entities.Task;
import glim.antony.timecontroller.entities.TimeUnit;
import glim.antony.timecontroller.services.TaskService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/tasks")
@Log4j2
public class TaskController {

    private TaskService taskService;

    @Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/") // http://192.168.1.62:8181/tc/tasks/
    @ResponseStatus(HttpStatus.OK)
    public String showTasks(Model model){
        List<Task> tasks = taskService.findAll();
        model.addAttribute("tasks", tasks);
        model.addAttribute("timeUnit", new TimeUnit(LocalDateTime.now()));
        return "index";
    }

    @GetMapping("/change/status")
    public String changeTaskStatus(
            @RequestParam (name = "id") Long id,
            @RequestParam (name = "newStatus") String newStatus
    ){
        log.info("[i] id = {}, newStatus = {}", id, newStatus);
        taskService.changeTaskStatus(id, newStatus);
        return "redirect:/tasks/";
    }

    @GetMapping("/edit")
    public String showEditForm(
            Model model,
            @RequestParam(name = "id", required = false) Long id
    ) {
        Task task = id != null ? taskService.findById(id) : new Task();
        model.addAttribute("task", task);
        return "edit-task";
    }

    @PostMapping("/edit/process")
    public String processAddOrEdit(
            @ModelAttribute("task") Task task
    ) {
        task.setUserId(1L);
        task.setType(Task.Type.THOUGHT);
        taskService.save(task);
        return "redirect:/tasks/";
    }

}
