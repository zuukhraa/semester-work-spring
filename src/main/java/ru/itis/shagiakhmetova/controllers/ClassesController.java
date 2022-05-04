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
import ru.itis.shagiakhmetova.services.ClassService;

@RequiredArgsConstructor
@Controller
@RequestMapping("/classes")
public class ClassesController {

    private final ClassService classService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping
    public String getClassesPage(Model model, @AuthenticationPrincipal AccountUserDetails userDetails) {
        Account account = userDetails.getAccount();
        model.addAttribute("classes", classService.findClassesByAccountsId(account.getId()));
        return "classes";
    }
}
