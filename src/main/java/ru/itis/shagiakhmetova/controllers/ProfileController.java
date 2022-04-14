package ru.itis.shagiakhmetova.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.shagiakhmetova.models.Account;
import ru.itis.shagiakhmetova.security.details.AccountUserDetails;

@Controller
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {

    @PreAuthorize("isAuthenticated()")
    @GetMapping
    public String getProfilePage(@AuthenticationPrincipal AccountUserDetails userDetails, Model model) {
        Account account = userDetails.getAccount();
        model.addAttribute("signUpForm", account);
        return "profile";
    }
}
