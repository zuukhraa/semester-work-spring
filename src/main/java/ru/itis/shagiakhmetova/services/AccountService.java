package ru.itis.shagiakhmetova.services;

import ru.itis.shagiakhmetova.dto.SignUpForm;

public interface AccountService {
    void signUp(SignUpForm form);
    void updateState(String confirmCode);
}
