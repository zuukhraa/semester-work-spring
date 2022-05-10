package ru.itis.shagiakhmetova.services;

import ru.itis.shagiakhmetova.dto.TaskDto;
import java.util.List;

public interface TasksService {
    List<TaskDto> getAllTasks();
    TaskDto addTask(TaskDto taskDto);
    void deleteTask(Long id);
    TaskDto updateTask(Long id, TaskDto taskDto);
}
