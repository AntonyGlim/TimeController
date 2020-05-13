package glim.antony.timecontroller.repositories;

import glim.antony.timecontroller.model.entities.Task;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {

    Task findOneById(Long id);

}
