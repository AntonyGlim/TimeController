package glim.antony.timecontroller.controllers;

import glim.antony.timecontroller.entities.Task;
import glim.antony.timecontroller.entities.TimeUnit;
import glim.antony.timecontroller.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private TaskService taskService;

    @Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/") // http://192.168.1.62:8181/tc/tasks/
    @ResponseStatus(HttpStatus.OK)
    public String showTasks(Model model){
        model.addAttribute("timeUnit", new TimeUnit(LocalDateTime.now()));
        return "index";
    }

}
