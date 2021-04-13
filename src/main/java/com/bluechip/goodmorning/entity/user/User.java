package com.bluechip.goodmorning.entity.user;

import com.bluechip.goodmorning.entity.BaseEntity;
import com.bluechip.goodmorning.entity.plan.PlanItem;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.util.*;

@ToString
@Getter
@Entity
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id")
    private long id;
    private String email;
    private String nickname;
    @OneToMany(mappedBy = "user")
    private List<PlanItem> planItemList = new ArrayList<>();

    public User() {}

    @Builder
    public User(String email, String nickname) {
        this.email = email;
        this.nickname = nickname;
    }

    public void addPlan(PlanItem planItem) {
        planItem.setUser(this);
        this.planItemList.add(planItem);
    }

}
