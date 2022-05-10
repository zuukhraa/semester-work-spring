package ru.itis.shagiakhmetova.services.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.shagiakhmetova.dto.TaskDto;
import ru.itis.shagiakhmetova.models.Tasks;
import ru.itis.shagiakhmetova.repositories.TasksRepository;
import ru.itis.shagiakhmetova.services.TasksService;
import java.util.List;

import static ru.itis.shagiakhmetova.dto.TaskDto.from;

@Service
@RequiredArgsConstructor
public class TasksServiceImpl implements TasksService {

    private final TasksRepository tasksRepository;

    @Override
    public List<TaskDto> getAllTasks() {
        return from(tasksRepository.findAll());
    }

    @Override
    public TaskDto addTask(TaskDto taskDto) {
        return from(tasksRepository.save(
                Tasks.builder()
                        .title(taskDto.getTitle())
                        .completed(taskDto.isCompleted())
                        .build()));
    }

    @Override
    public void deleteTask(Long id) {
        Tasks task = tasksRepository.getById(id);
        tasksRepository.delete(task);
    }

    @Override
    public TaskDto updateTask(Long id, TaskDto taskDto) {
        Tasks tasks = tasksRepository.getById(id);
        tasks.setCompleted(taskDto.isCompleted());
        return from(tasksRepository.save(tasks));
    }
}
