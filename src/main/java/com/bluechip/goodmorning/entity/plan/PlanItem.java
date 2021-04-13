package com.bluechip.goodmorning.entity.plan;

import com.bluechip.goodmorning.entity.BaseEntity;
import com.bluechip.goodmorning.entity.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;


@ToString
@Getter
@Entity
public class PlanItem extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="plan_item_id")
    private long id;
    private String contents;
    private boolean isCompleted;
    private PlanType planType;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public PlanItem() {}

    @Builder
    public PlanItem(String contents, boolean isCompleted, PlanType planType) {
        this.contents = contents;
        this.isCompleted = isCompleted;
        this.planType = planType;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
