package com.bluechip.goodmorning.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PlanItemTest {

    @Test
    void lombokTest() {
        String contents = "운동하기";

        PlanItem planItem = PlanItem.builder()
                                        .contents(contents)
                                        .planType(PlanType.TO_DO)
                                        .isCompleted(false)
                                        .build();

        assertThat(planItem.getContents()).isEqualTo(contents);
        assertThat(planItem.getPlanType()).isEqualTo(PlanType.TO_DO);
        assertThat(planItem.isCompleted()).isFalse();

    }

}