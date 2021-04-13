package com.bluechip.goodmorning.repository.plan;

import com.bluechip.goodmorning.entity.plan.PlanItem;
import org.springframework.data.jpa.repository.JpaRepository;

interface PlanItemRepository extends JpaRepository<PlanItem, Long> {
}
