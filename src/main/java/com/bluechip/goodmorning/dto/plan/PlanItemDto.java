package com.bluechip.goodmorning.dto.plan;

import com.bluechip.goodmorning.entity.plan.PlanItem;
import com.bluechip.goodmorning.entity.plan.PlanType;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PlanItemDto {
    private long id;
    private String contents;
    private boolean isCompleted;
    private PlanType planType;

    public static PlanItemDto of(PlanItem planItem) {
        return PlanItemDto.builder()
                                .id(planItem.getId())
                                .contents(planItem.getContents())
                                .isCompleted(planItem.isCompleted())
                                .planType(planItem.getPlanType())
                            .build();
    }
}
