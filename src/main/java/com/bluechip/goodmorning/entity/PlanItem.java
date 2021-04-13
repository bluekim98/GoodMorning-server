package com.bluechip.goodmorning.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;


@ToString
@Getter
@Entity
public class PlanItem {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="plan_item_id")
    private long id;
    private String contents;
    private boolean isCompleted;
    private PlanType planType;

    public PlanItem() {}

    @Builder
    public PlanItem(String contents, boolean isCompleted, PlanType planType) {
        this.contents = contents;
        this.isCompleted = isCompleted;
        this.planType = planType;
    }
}
