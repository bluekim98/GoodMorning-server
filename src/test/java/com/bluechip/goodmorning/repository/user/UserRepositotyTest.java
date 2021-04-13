package com.bluechip.goodmorning.repository.user;

import com.bluechip.goodmorning.entity.user.User;
import javassist.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositotyTest {

    @Autowired
    private UserRepositoty userRepositoty;

    @Test
    @Transactional
    void jpaAuditingTest() throws NotFoundException {
        String email = "blue@naver.com";
        String nickname = "blue";
        User user = User.builder()
                        .email(email)
                        .nickname(nickname)
                        .build();

        userRepositoty.save(user);

        User findedUser = userRepositoty.findByEmail(email)
                                            .orElseThrow(() -> new NotFoundException("user not found"));

        assertThat(findedUser.getCreated_at()).isNotNull();
        assertThat(findedUser.getUpdated_at()).isNotNull();
    }
}