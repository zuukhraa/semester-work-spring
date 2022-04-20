package ru.itis.shagiakhmetova.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.shagiakhmetova.dto.PostDto;
import ru.itis.shagiakhmetova.models.Account;
import ru.itis.shagiakhmetova.security.details.AccountUserDetails;
import ru.itis.shagiakhmetova.services.PostService;

@Controller
@RequiredArgsConstructor
public class ProfileController {

    @Autowired
    private final PostService postService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/profile")
    public String getProfilePage(@AuthenticationPrincipal AccountUserDetails userDetails, Model model) {
        Account account = userDetails.getAccount();
        model.addAttribute("account", account);
        return "profile";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("profile/{account-id}/post")
    public String addPost(@PathVariable("account-id") Long accountId,PostDto post) {
        postService.addPost(post, accountId);
        return "redirect:/profile";
    }
}
