package uz.itpu.tasktracker.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uz.itpu.tasktracker.dto.TaskDto;
import uz.itpu.tasktracker.service.TaskService;

import java.util.List;
@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {
    @Override
    public TaskDto createTask(TaskDto taskDto) {
        return null;
    }

    @Override
    public TaskDto updateTask(Integer id, TaskDto taskDto) {
        return null;
    }

    @Override
    public String deleteTask(Integer id) {
        return null;
    }

    @Override
    public TaskDto getTask(Integer id) {
        return null;
    }

    @Override
    public List<TaskDto> getAllTask() {
        return null;
    }
}
