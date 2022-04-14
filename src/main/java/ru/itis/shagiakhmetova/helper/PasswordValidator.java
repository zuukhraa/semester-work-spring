package ru.itis.shagiakhmetova.helper;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Validator, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.matches("(?=.*\\d+.*)(?=.*[A-Z]+.*)\\w{4,12}");
    }
}

