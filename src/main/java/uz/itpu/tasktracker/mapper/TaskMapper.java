package uz.itpu.tasktracker.mapper;

import org.springframework.stereotype.Component;
import uz.itpu.tasktracker.dto.TaskDto;
import uz.itpu.tasktracker.entity.TaskEntity;

@Component
public class TaskMapper {

    public TaskEntity dtoToEntity(TaskDto taskDto) {

        return new TaskEntity();
    }

    public TaskDto entityToDto(TaskEntity taskEntity) {

        return TaskDto.builder()
                .build();
    }
}
