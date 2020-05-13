package glim.antony.timecontroller.repositories;

import glim.antony.timecontroller.model.entities.UsefulDate;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UsefulDateRepository extends PagingAndSortingRepository<UsefulDate, Long> {
    List<UsefulDate> findAllByUserIdAndDateBetween(Long id, LocalDate firstDate, LocalDate lastDate);
}
