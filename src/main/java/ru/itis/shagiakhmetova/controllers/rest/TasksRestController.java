package ru.itis.shagiakhmetova.controllers.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.shagiakhmetova.dto.TaskDto;
import ru.itis.shagiakhmetova.services.TasksService;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class TasksRestController {

    private final TasksService tasksService;

    @GetMapping("tasks/getAllTasks")
    public ResponseEntity<List<TaskDto>> getAllTasks() {
        return ResponseEntity.ok(tasksService.getAllTasks());
    }

    @PostMapping(value ="tasks/addTask")
    public ResponseEntity<TaskDto> addTasks(@RequestBody TaskDto taskDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(tasksService.addTask(taskDto));
    }

    @PutMapping("tasks/update/{task-id}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable("task-id") Long id,
                                              @RequestBody TaskDto task) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(tasksService.updateTask(id, task));
    }

    @DeleteMapping("tasks/deleteTask/{task-id}")
    public void deleteTask(@PathVariable("task-id") Long id) {
        tasksService.deleteTask(id);
    }
}
