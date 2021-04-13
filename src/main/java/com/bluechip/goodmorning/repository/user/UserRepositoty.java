package com.bluechip.goodmorning.repository.user;

import com.bluechip.goodmorning.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositoty extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
