package ru.itis.shagiakhmetova.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.shagiakhmetova.services.PostService;

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

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/{post-id}/delete")
    public String deleteAccount(@PathVariable("post-id") Long postId) {
        postService.deletePost(postId);
        return "redirect:/posts";
    }

}
