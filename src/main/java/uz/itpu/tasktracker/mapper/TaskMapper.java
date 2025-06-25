package uz.itpu.tasktracker.mapper;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uz.itpu.tasktracker.dto.TaskDto;
import uz.itpu.tasktracker.entity.TaskEntity;
import uz.itpu.tasktracker.utils.DateTimeUtils;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class TaskMapper {
    public static TaskEntity dtoToEntity(TaskDto taskDto) {
        if (Objects.nonNull(taskDto)) {
            return TaskEntity.builder()
                    .id(taskDto.getId())
                    .title(taskDto.getTitle())
                    .content(taskDto.getContent())
                    .status(taskDto.getStatus())
                    .priority(taskDto.getPriority())
                    .dueDate(DateTimeUtils.convertTimestampToDate(taskDto.getDueDate()))
                    .createDate(DateTimeUtils.convertTimestampToDate(taskDto.getCreatedDate()))
                    .build();
        }
        return new TaskEntity();
    }

    public static TaskDto entityToDto(TaskEntity taskEntity) {
        if (Objects.nonNull(taskEntity)) {
            return TaskDto.builder()
                    .id(taskEntity.getId())
                    .title(taskEntity.getTitle())
                    .content(taskEntity.getContent())
                    .status(taskEntity.getStatus())
                    .priority(taskEntity.getPriority())
                    .dueDate(DateTimeUtils.convertDateToTimestamp(taskEntity.getDueDate()))
                    .createdDate(DateTimeUtils.convertDateToTimestamp(taskEntity.getCreateDate()))
                    .build();
        }
        return new TaskDto();
    }
}
