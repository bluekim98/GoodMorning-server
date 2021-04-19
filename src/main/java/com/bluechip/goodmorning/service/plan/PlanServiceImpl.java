package com.bluechip.goodmorning.service.plan;

import com.bluechip.goodmorning.dto.plan.PlanItemDto;
import com.bluechip.goodmorning.entity.plan.PlanItem;
import com.bluechip.goodmorning.entity.user.User;
import com.bluechip.goodmorning.repository.plan.PlanItemRepository;
import com.bluechip.goodmorning.repository.user.UserRepositoty;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class PlanServiceImpl implements PlanService{

    final private PlanItemRepository planItemRepository;
    final private UserRepositoty userRepositoty;

    @Autowired
    public PlanServiceImpl(PlanItemRepository planItemRepository, UserRepositoty userRepositoty) {
        this.planItemRepository = planItemRepository;
        this.userRepositoty = userRepositoty;
    }

    @Override
    public List<PlanItemDto> getPlanListBy(String userEmail) {
        User user = findUserEntityBy(userEmail);
        List<PlanItem> planItemList = user.getPlanItemList();
        List<PlanItemDto> planItemDtoList = convertPlanItemDtoList(planItemList);
        return planItemDtoList;
    }

    private User findUserEntityBy(String userEmail) {
        User user = null;
        try {
            user = userRepositoty.findByEmail(userEmail)
                    .orElseThrow(() -> new NotFoundException("not found user"));
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }

    private List<PlanItemDto> convertPlanItemDtoList(List<PlanItem> planItemList) {
        List<PlanItemDto> planItemDtoList = new ArrayList<>();
        for(PlanItem planItem : planItemList) {
            PlanItemDto planItemDto = PlanItemDto.of(planItem);
            planItemDtoList.add(planItemDto);
        }
        return planItemDtoList;
    }
}
