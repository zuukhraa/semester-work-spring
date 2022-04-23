package ru.itis.shagiakhmetova.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.itis.shagiakhmetova.dto.AccountDto;
import ru.itis.shagiakhmetova.dto.PostDto;
import ru.itis.shagiakhmetova.models.Account;
import ru.itis.shagiakhmetova.security.details.AccountUserDetails;
import ru.itis.shagiakhmetova.services.AccountService;
import ru.itis.shagiakhmetova.services.PostService;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ProfileController {

    @Autowired
    private final PostService postService;

    private final AccountService accountService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/profile")
    public String getProfilePage(@AuthenticationPrincipal AccountUserDetails userDetails, Model model) {
        Optional<Account> accountByEmail = accountService.getAccountByEmail(userDetails.getUsername());
        if (accountByEmail.isPresent()) {
            Account account = accountByEmail.get();
            model.addAttribute("account", account);
            model.addAttribute("firstName", account.getFirstName());
            model.addAttribute("lastName", account.getLastName());
            model.addAttribute("password", account.getPassword());
        }
        return "profile";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("profile/{account-id}/post")
    public String addPost(@PathVariable("account-id") Long accountId,PostDto post) {
        postService.addPost(post, accountId);
        return "redirect:/profile";
    }

    @GetMapping("/profile/update")
    public String getEditPage(Model model) {
        model.addAttribute("accountDto", new AccountDto());
        return "changes";
    }

    @PostMapping("/profile/update")
    public String update(@Valid AccountDto accountDto, @AuthenticationPrincipal AccountUserDetails userDetails, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("accountDto", accountDto);
            return "changes";
        }
        String email = userDetails.getUsername();
        accountService.update(accountDto, email);
        return "redirect:/profile";
    }
}
