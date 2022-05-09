package ru.itis.shagiakhmetova.services.Impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import ru.itis.shagiakhmetova.dto.PostDto;
import ru.itis.shagiakhmetova.helper.exceptions.AccountNotExistsException;
import ru.itis.shagiakhmetova.models.Account;
import ru.itis.shagiakhmetova.models.Post;
import ru.itis.shagiakhmetova.repositories.AccountRepository;
import ru.itis.shagiakhmetova.repositories.PostRepository;
import ru.itis.shagiakhmetova.services.PostService;
import java.time.LocalDate;
import java.util.List;

import static ru.itis.shagiakhmetova.dto.PostDto.from;

@Service
@RequiredArgsConstructor
@Log4j2
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    private final AccountRepository accountRepository;

    @Override
    public void addPost(PostDto postDto, Long accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(AccountNotExistsException::new);
        Post newPost = Post.builder()
                .title(postDto.getTitle())
                .text(postDto.getText())
                .state(Post.State.PUBLISHED)
                .createdAt(LocalDate.now())
                .account(account)
                .build();
        postRepository.save(newPost);
    }

    @Override
    public void deletePost(Long postId) {
        Post post = postRepository.getById(postId);
        post.setState(Post.State.DELETED);
        postRepository.save(post);
    }

    @Override
    public List<PostDto> searchPostByTitle(String title) {
        return from(postRepository.findAllByTitleLike('%' + title + '%'));
    }

    @Override
    public List<PostDto> getAllPosts() {
        return from(postRepository.findAllByState(Post.State.PUBLISHED));
    }
}
