package com.bluechip.goodmorning.service.plan;

import com.bluechip.goodmorning.dto.plan.PlanItemDto;
import com.bluechip.goodmorning.entity.plan.PlanItem;
import com.bluechip.goodmorning.entity.plan.PlanType;
import com.bluechip.goodmorning.entity.user.User;
import com.bluechip.goodmorning.repository.plan.PlanItemRepository;
import com.bluechip.goodmorning.repository.user.UserRepositoty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@Rollback(false)
@SpringBootTest
class PlanServiceImplTest {

    final private PlanItemRepository planItemRepository;
    final private UserRepositoty userRepositoty;
    final private PlanService planService;

    final private String userEmail = "blue@naver.com";
    final private String[] contentsArray = {
            "운동하기", "독서하기", "강아지산책하기", "빨래하기"
    };

    @Autowired
    public PlanServiceImplTest(PlanItemRepository planItemRepository, UserRepositoty userRepositoty
            , PlanService planService) {
        this.planItemRepository = planItemRepository;
        this.userRepositoty = userRepositoty;
        this.planService = planService;
    }

    @Transactional
    @BeforeEach
    void insertData() {
        String nickname = "blue";
        User user = User.builder()
                        .email(userEmail)
                        .nickname(nickname)
                        .build();
        userRepositoty.save(user);

        for(String contents : contentsArray) {
            PlanItem planItem = PlanItem.builder()
                    .contents(contents)
                    .planType(PlanType.TO_DO)
                    .isCompleted(false)
                    .build();
            user.addPlan(planItem);
            planItemRepository.save(planItem);
        }
    }

    @Transactional
    @Test
    void getPlanListByUserEmail() throws ClassNotFoundException {
        List<PlanItemDto> planItemList = planService.getPlanListBy(userEmail);

        assertThat(planItemList.size()).isEqualTo(contentsArray.length);

    }


}