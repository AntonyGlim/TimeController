package glim.antony.timecontroller.services;

import glim.antony.timecontroller.model.entities.UsefulDCTask;
import glim.antony.timecontroller.repositories.UsefulDCTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UsefulDCTaskService {
    private UsefulDCTaskRepository usefulDCTaskRepository;

    @Autowired
    public void setUsefulDCTaskRepository(UsefulDCTaskRepository usefulDCTaskRepository) {
        this.usefulDCTaskRepository = usefulDCTaskRepository;
    }

    public List<UsefulDCTask> findAllByTaskIdAndDateBetween(Long id, LocalDate firstDate, LocalDate lastDate){
        return usefulDCTaskRepository.findAllByTaskIdAndDateBetween(id, firstDate, lastDate);
    }
}
