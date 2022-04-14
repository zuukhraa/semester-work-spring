package ru.itis.shagiakhmetova.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.shagiakhmetova.models.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
