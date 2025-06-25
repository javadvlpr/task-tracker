package uz.itpu.tasktracker.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uz.itpu.tasktracker.dto.TaskDto;
import uz.itpu.tasktracker.entity.TaskEntity;
import uz.itpu.tasktracker.exception.TaskNotFoundException;
import uz.itpu.tasktracker.mapper.TaskMapper;
import uz.itpu.tasktracker.repository.TaskRepository;
import uz.itpu.tasktracker.service.TaskService;
import uz.itpu.tasktracker.utils.DateTimeUtils;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    @Override
    public TaskDto createTask(TaskDto taskDto) {
        TaskEntity taskEntity = TaskMapper.dtoToEntity(taskDto);
        TaskEntity savedTask = taskRepository.save(taskEntity);
        return TaskMapper.entityToDto(savedTask);
    }

    @Override
    public TaskDto updateTask(Integer id, TaskDto taskDto) {
        TaskMapper.dtoToEntity(taskDto);
        Optional<TaskEntity> byId = taskRepository.findById(id);
        if (byId.isPresent()) {
            TaskEntity taskEntity = byId.get();
            taskEntity.setTitle(taskDto.getTitle());
            taskEntity.setContent(taskDto.getContent());
            taskEntity.setStatus(taskDto.getStatus());
            taskEntity.setPriority(taskDto.getPriority());
            taskEntity.setDueDate(DateTimeUtils.convertTimestampToDate(taskDto.getDueDate()));
            taskEntity.setCreateDate(DateTimeUtils.convertTimestampToDate(taskDto.getCreatedDate()));
            TaskEntity updatedTask = taskRepository.save(taskEntity);
            return TaskMapper.entityToDto(updatedTask);
        }
        throw new TaskNotFoundException(id);
    }

    @Override
    public String deleteTask(Integer id) {
        Optional<TaskEntity> byId = taskRepository.findById(id);
        if (byId.isPresent()) {
            taskRepository.delete(byId.get());
            return "Task with id " + id + " deleted successfully.";
        }
        throw new TaskNotFoundException(id);
    }

    @Override
    public TaskDto getTask(Integer id) {
        Optional<TaskEntity> byId = taskRepository.findById(id);
        if (byId.isPresent()) {
            return TaskMapper.entityToDto(byId.get());
        }
        throw new TaskNotFoundException(id);
    }

    @Override
    public List<TaskDto> getAllTask() {
        List<TaskEntity> allTasks = taskRepository.findAll();
        if (!allTasks.isEmpty()) {
            return allTasks.stream()
                    .map(TaskMapper::entityToDto)
                    .toList();
        }
        return List.of(); // Return an empty list if no tasks are found
    }
}
