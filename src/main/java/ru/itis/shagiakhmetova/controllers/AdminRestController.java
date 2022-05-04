package ru.itis.shagiakhmetova.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.itis.shagiakhmetova.dto.AccountDto;
import ru.itis.shagiakhmetova.services.AccountService;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/accounts")
public class AdminRestController {

    private final AccountService accountsService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAccountsPage() {
        return ResponseEntity.ok(accountsService.getAllAccounts());
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/addAccount")
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(accountsService.save(accountDto));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/{account-id}/delete")
    public void deleteAccount(@PathVariable("account-id") Long accountId) {
       accountsService.deleteAccount(accountId);
    }

}
