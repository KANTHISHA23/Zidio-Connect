package com.zidio.job_portal.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zidio.job_portal.Entity.SubscriptionPlan;
import com.zidio.job_portal.Repository.SubscriptionPlanRepository;

import java.util.Optional;

@Service
public class SubscriptionPlanService {

    @Autowired
    private SubscriptionPlanRepository planRepository;

    public SubscriptionPlan savePlan(SubscriptionPlan plan) {
        return planRepository.save(plan);
    }

    public SubscriptionPlan getPlanById(Long id) {
        return planRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plan not found with ID: " + id));
    }

    public void deletePlanById(Long id) {
        if (!planRepository.existsById(id)) {
            throw new RuntimeException("Cannot delete. Plan not found with ID: " + id);
        }
        planRepository.deleteById(id);
    }
}