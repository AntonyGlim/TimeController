package glim.antony.timecontroller.controllers;

import glim.antony.timecontroller.entities.Task;
import glim.antony.timecontroller.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/v1/tasks")
public class TaskRestController {

    private TaskService taskService;

    @Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/") // http://192.168.1.62:8181/tc/rest/v1/tasks/
    @ResponseStatus(HttpStatus.OK)
    public List<Task> showTasks(){
        return taskService.findAll();
    }

}
