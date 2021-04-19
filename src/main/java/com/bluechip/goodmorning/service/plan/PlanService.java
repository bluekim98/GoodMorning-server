package com.bluechip.goodmorning.service.plan;

import com.bluechip.goodmorning.dto.plan.PlanItemDto;

import java.util.List;

public interface PlanService {
    public List<PlanItemDto> getPlanListBy(String userEmail);
}
