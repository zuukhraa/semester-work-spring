package ru.itis.shagiakhmetova.services.Impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import ru.itis.shagiakhmetova.dto.ClassDto;
import ru.itis.shagiakhmetova.repositories.ClassRepository;
import ru.itis.shagiakhmetova.services.ClassService;

import java.util.List;

import static ru.itis.shagiakhmetova.dto.ClassDto.from;

@Service
@RequiredArgsConstructor
@Log4j2
public class ClassServiceImpl implements ClassService {

    private final ClassRepository classRepository;

    @Override
    public List<ClassDto> findClassesByAccountsId(Long id) {
        return from(classRepository.findClassesByAccountsId(id));
    }
}
