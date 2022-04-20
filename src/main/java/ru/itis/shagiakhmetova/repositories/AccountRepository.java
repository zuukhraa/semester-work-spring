package ru.itis.shagiakhmetova.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.shagiakhmetova.models.Account;
import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByEmail (String email);
    Account findAllByConfirmCode( String code);
    List<Account> findAllByState(Account.State state);
}
