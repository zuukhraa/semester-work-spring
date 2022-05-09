package ru.itis.shagiakhmetova.controllers.rest;

import lombok.RequiredArgsConstructor;
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
}
