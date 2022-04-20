package ru.itis.shagiakhmetova.dto;

import ru.itis.shagiakhmetova.models.Account;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class AccountDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String faculty_name;
    private FileDto avatar;

    public static AccountDto from(Account account) {
        return AccountDto.builder()
                .id(account.getId())
                .firstName(account.getFirstName())
                .lastName(account.getLastName())
                .email(account.getEmail())
                .build();
    }

    public static List<AccountDto> from(List<Account> accounts) {
        return accounts.stream().map(AccountDto::from).collect(Collectors.toList());
    }
}
