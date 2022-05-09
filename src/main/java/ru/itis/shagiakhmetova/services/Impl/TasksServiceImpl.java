package ru.itis.shagiakhmetova.services.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.shagiakhmetova.dto.TaskDto;
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
}
