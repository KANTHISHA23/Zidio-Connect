package com.zidio.job_portal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zidio.job_portal.Entity.SubscriptionPlan;

public interface SubscriptionPlanRepository extends JpaRepository<SubscriptionPlan, Long> {
    // No need to define save(), findById(), or deleteById() — they come built-in!
}