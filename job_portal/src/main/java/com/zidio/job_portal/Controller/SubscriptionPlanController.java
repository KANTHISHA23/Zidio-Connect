package com.zidio.job_portal.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.zidio.job_portal.Entity.SubscriptionPlan;
import com.zidio.job_portal.Service.SubscriptionPlanService;

@RestController
@RequestMapping("/api/plans")
public class SubscriptionPlanController {

    @Autowired
    private SubscriptionPlanService subscriptionPlanService;

    @PostMapping("/add")
    public ResponseEntity<SubscriptionPlan> addPlan(@RequestBody SubscriptionPlan plan) {
        SubscriptionPlan savedPlan = subscriptionPlanService.savePlan(plan);
        return ResponseEntity.ok(savedPlan);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionPlan> getPlanById(@PathVariable Long id) {
        SubscriptionPlan plan = subscriptionPlanService.getPlanById(id);
        return ResponseEntity.ok(plan);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlan(@PathVariable Long id) {
        subscriptionPlanService.deletePlanById(id);
        return ResponseEntity.ok("Plan deleted successfully");
    }
}