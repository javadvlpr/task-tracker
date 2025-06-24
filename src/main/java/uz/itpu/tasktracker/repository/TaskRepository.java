package uz.itpu.tasktracker.repository;

import org.springframework.data.repository.CrudRepository;
import uz.itpu.tasktracker.entity.TaskEntity;

public interface TaskRepository extends CrudRepository<TaskEntity, Integer> {

}
