package ru.itis.shagiakhmetova.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.shagiakhmetova.dto.AccountDto;
import ru.itis.shagiakhmetova.dto.SignUpForm;
import ru.itis.shagiakhmetova.models.Account;
import ru.itis.shagiakhmetova.repositories.AccountRepository;
import ru.itis.shagiakhmetova.util.EmailUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import static ru.itis.shagiakhmetova.dto.AccountDto.from;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    @Autowired
    private final AccountRepository accountRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    private EmailUtil emailUtil;

    @Value("${server.port}")
    String port;

    @Transactional
    @Override
    public void signUp(SignUpForm signUpForm) {
        Account newUser = Account.builder()
                .firstName(signUpForm.getFirstName())
                .lastName(signUpForm.getLastName())
                .email(signUpForm.getEmail().toLowerCase(Locale.ROOT))
                .password(passwordEncoder.encode(signUpForm.getPassword()))
                .faculty_name(signUpForm.getFaculty_name())
                .confirmCode(UUID.randomUUID().toString())
                .state(Account.State.NOT_CONFIRMED)
                .role(Account.Role.USER)
                .build();
        accountRepository.save(newUser);

        HashMap<String, String> data = new HashMap<>();
        data.put("confirm_code", newUser.getConfirmCode());
        data.put("first_name", newUser.getFirstName());
        data.put("port", port);
        emailUtil.sendMail(newUser.getEmail(), "confirm", "mails/confirm_mail.ftlh",
                data);
    }

    @Override
    public void updateState(String confirmCode) {
        Account account = accountRepository.findAllByConfirmCode(confirmCode);
        account.setState(Account.State.CONFIRMED);
        accountRepository.save(account);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        return from(accountRepository.findAllByState(Account.State.CONFIRMED));
    }

    @Override
    public void deleteAccount(Long accountId) {
        Account account = accountRepository.getById(accountId);
        account.setState(Account.State.DELETED);
        accountRepository.save(account);
    }
}
