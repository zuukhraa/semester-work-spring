package ru.itis.shagiakhmetova.services;

import ru.itis.shagiakhmetova.dto.ClassDto;

import java.util.List;

public interface ClassService {
    List<ClassDto> findClassesByAccountsId(Long id);
}
