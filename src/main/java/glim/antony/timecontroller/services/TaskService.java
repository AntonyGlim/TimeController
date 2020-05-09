package glim.antony.timecontroller.services;

import glim.antony.timecontroller.entities.Task;
import glim.antony.timecontroller.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    @Autowired
    public void setTaskRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll() {
        return (List<Task>) taskRepository.findAll();
    }

    public Task findById(Long id) {
        return taskRepository.findById(id).get();
    }

    public Task save(Task task){
        return taskRepository.save(task);
    }

    public void changeTaskStatus(Long id, String newStatus) {
        Task task = taskRepository.findOneById(id);
        task.setType(Task.Type.valueOf(newStatus));
        save(task);
    }
}
