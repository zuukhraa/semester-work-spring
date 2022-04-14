package ru.itis.shagiakhmetova.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/")
    public String getRootPage() {
        return "redirect:/profile";
    }
}
