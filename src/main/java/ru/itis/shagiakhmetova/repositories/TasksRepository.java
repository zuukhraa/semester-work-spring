package ru.itis.shagiakhmetova.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.shagiakhmetova.models.Tasks;

import java.util.List;

public interface TasksRepository extends JpaRepository<Tasks, Long> {
}
