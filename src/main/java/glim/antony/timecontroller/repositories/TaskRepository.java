package glim.antony.timecontroller.repositories;

import glim.antony.timecontroller.entities.Task;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {

}
