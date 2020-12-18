package everis.everisdarmytasksms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import everis.everisdarmytasksms.model.Task;

@Repository
public interface TaskRepository  extends CrudRepository<Task, Long>{

}