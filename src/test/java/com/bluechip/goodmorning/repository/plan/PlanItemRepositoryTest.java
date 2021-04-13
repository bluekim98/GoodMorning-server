package com.bluechip.goodmorning.repository.plan;

import com.bluechip.goodmorning.entity.plan.PlanItem;
import com.bluechip.goodmorning.entity.plan.PlanType;
import com.bluechip.goodmorning.entity.user.User;
import com.bluechip.goodmorning.repository.user.UserRepositoty;
import javassist.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PlanItemRepositoryTest {

    @Autowired
    private PlanItemRepository planItemRepository;
    @Autowired
    private UserRepositoty userRepositoty;

    @Test
    @Transactional
    void joinToUserTest() throws NotFoundException {
        // given
        String email = "blue@naver.com";
        String nickname = "blue";

        User user = User.builder()
                        .email(email)
                        .nickname(nickname)
                        .build();
        userRepositoty.save(user);

        String contents = "운동하기";

        PlanItem planItem = PlanItem.builder()
                .contents(contents)
                .planType(PlanType.TO_DO)
                .isCompleted(false)
                .build();

        user.addPlan(planItem);

        planItemRepository.save(planItem);
        // when
        User savedUser = userRepositoty.findByEmail(email)
                                        .orElseThrow(() -> new NotFoundException("user 저장 안됨"));

        // then
        assertThat(savedUser.getEmail()).isEqualTo(email);
        assertThat(savedUser.getPlanItemList().size()).isEqualTo(1);
        assertThat(savedUser.getPlanItemList().get(0).getContents()).isEqualTo(contents);
    }
}