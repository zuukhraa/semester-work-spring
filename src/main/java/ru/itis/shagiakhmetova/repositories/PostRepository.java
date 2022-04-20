package ru.itis.shagiakhmetova.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.shagiakhmetova.models.Account;
import ru.itis.shagiakhmetova.models.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByState(Post.State state);
}
