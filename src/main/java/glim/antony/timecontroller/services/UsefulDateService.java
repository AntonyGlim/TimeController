package glim.antony.timecontroller.services;

import glim.antony.timecontroller.model.entities.UsefulDate;
import glim.antony.timecontroller.repositories.UsefulDateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UsefulDateService {

    private UsefulDateRepository usefulDateRepository;

    @Autowired
    public void setUsefulDateRepository(UsefulDateRepository usefulDateRepository) {
        this.usefulDateRepository = usefulDateRepository;
    }

    public List<UsefulDate> findAllByUserIdAndDateBetween(Long id, LocalDate firstDate, LocalDate lastDate){
        return usefulDateRepository.findAllByUserIdAndDateBetween(id, firstDate, lastDate);
    }
}
