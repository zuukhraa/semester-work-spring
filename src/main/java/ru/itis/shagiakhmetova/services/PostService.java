package ru.itis.shagiakhmetova.services;

import ru.itis.shagiakhmetova.dto.PostDto;
import java.util.List;

public interface PostService {
    void addPost(PostDto postDto, Long accountId);
    List<PostDto> getAllPosts();
    void deletePost(Long postId);
}
