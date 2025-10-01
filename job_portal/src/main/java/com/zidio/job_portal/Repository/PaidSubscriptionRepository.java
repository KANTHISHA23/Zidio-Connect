package com.zidio.job_portal.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zidio.job_portal.Entity.PaidSubscription;

@Repository
public interface PaidSubscriptionRepository extends JpaRepository<PaidSubscription, Long>{

	List<PaidSubscription>findByRecruiterId(Long recruiterId);
	List<PaidSubscription>findByEmployeeId(Long employeeID);
	List<PaidSubscription>findByUserEmail(String userEmail);

}
