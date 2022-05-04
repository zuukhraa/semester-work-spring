package ru.itis.shagiakhmetova.services;

import ru.itis.shagiakhmetova.dto.AccountDto;
import ru.itis.shagiakhmetova.dto.SignUpForm;
import ru.itis.shagiakhmetova.models.Account;
import java.util.List;
import java.util.Optional;

public interface AccountService {
    void signUp(SignUpForm form);
    void updateState(String confirmCode);
    List<AccountDto> getAllAccounts();
    void deleteAccount(Long accountId);
    void update(AccountDto accountDto, String email);
    Optional<Account> getAccountByEmail(String email);
    AccountDto save(AccountDto accountDto);
}
