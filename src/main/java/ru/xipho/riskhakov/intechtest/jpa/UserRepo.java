package ru.xipho.riskhakov.intechtest.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.xipho.riskhakov.intechtest.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
