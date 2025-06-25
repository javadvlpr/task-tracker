package uz.itpu.tasktracker.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.itpu.tasktracker.dto.TaskDto;
import uz.itpu.tasktracker.service.TaskService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/task")
@Api(tags = "Task Endpoints")
public class TaskController {
    private final TaskService taskService;
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Create Task")
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto) {
        taskDto.setId(null);
        return ResponseEntity.ok(taskService.createTask(taskDto));
    }

    @PutMapping("/update/{id}")
    @ApiOperation("Update Task by id")
    public ResponseEntity<TaskDto> updateTask(@PathVariable Integer id, @RequestBody TaskDto taskDto) {
        taskDto.setId(null);
        return ResponseEntity.ok(taskService.updateTask(id, taskDto));
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Delete Task by id")
    public ResponseEntity<String> deleteTask(@PathVariable Integer id) {
        return ResponseEntity.ok(taskService.deleteTask(id));
    }

    @GetMapping("/get-by-id/{id}")
    @ApiOperation("Get Task by id")
    public ResponseEntity<TaskDto> getTask(@PathVariable Integer id) {
        return ResponseEntity.ok(taskService.getTask(id));
    }

    @GetMapping("/get-all")
    @ApiOperation("Get list of all Tasks")
    public ResponseEntity<List<TaskDto>> getAllTask() {
        return ResponseEntity.ok(taskService.getAllTask());
    }
}