package com.zidio.job_portal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zidio.job_portal.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
  
	Employee findByEmail(String email);
	
}
