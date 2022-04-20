package ru.itis.shagiakhmetova.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.shagiakhmetova.services.AccountService;

@RequiredArgsConstructor
@Controller
@RequestMapping("/accounts")
public class AdminController {

    private final AccountService accountsService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public String getAccountsPage(Model model) {
        model.addAttribute("accounts", accountsService.getAllAccounts());
        return "accounts";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/{account-id}/delete")
    public String deleteAccount(@PathVariable("account-id") Long accountId) {
        accountsService.deleteAccount(accountId);
        return "redirect:/accounts";
    }
}
