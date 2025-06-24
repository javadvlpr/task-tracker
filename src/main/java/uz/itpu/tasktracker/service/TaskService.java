package uz.itpu.tasktracker.service;

import uz.itpu.tasktracker.dto.TaskDto;

import java.util.List;

public interface TaskService {
    TaskDto createTask(TaskDto taskDto);

    TaskDto updateTask(Integer id, TaskDto taskDto);

    String deleteTask(Integer id);

    TaskDto getTask(Integer id);

    List<TaskDto> getAllTask();
}
