package ru.itis.shagiakhmetova.helper;

import lombok.RequiredArgsConstructor;
import ru.itis.shagiakhmetova.models.Account;
import ru.itis.shagiakhmetova.repositories.AccountRepository;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@RequiredArgsConstructor
public class EmailValidator implements ConstraintValidator<ValidEmail, String> {

    private final AccountRepository accountRepository;
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Optional<Account> account = accountRepository.findByEmail(value);
        if (account.isPresent()) {
            return false;
        }
        return true;
    }
}
