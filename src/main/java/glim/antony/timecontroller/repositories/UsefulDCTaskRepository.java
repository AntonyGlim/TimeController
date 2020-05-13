package glim.antony.timecontroller.repositories;

import glim.antony.timecontroller.model.entities.UsefulDCTask;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UsefulDCTaskRepository extends PagingAndSortingRepository<UsefulDCTask, Long> {
    List<UsefulDCTask> findAllByTaskIdAndDateBetween(Long id, LocalDate firstDate, LocalDate lastDate);
}
