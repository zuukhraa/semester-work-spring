package ru.itis.shagiakhmetova.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.shagiakhmetova.dto.PostDto;
import ru.itis.shagiakhmetova.services.PostService;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/posts")
public class PostsController {

    private final PostService postService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping
    public String getAccountsPage(Model model) {
        model.addAttribute("posts", postService.getAllPosts());
        return "posts";
    }

    @GetMapping("/search")
    public String getPostsSearchPage() {
        return "searchPost";
    }

    @GetMapping(value = "/search/{title}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<PostDto> searchPostByTitle(@PathVariable("title") String title) {
        return postService.searchPostByTitle(title);
    }
}
