package everisdarmytasksms.firstproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import everisdarmytasksms.firstproject.model.Task;

@Repository
public interface TaskRepository  extends CrudRepository<Task, Long>{

}
