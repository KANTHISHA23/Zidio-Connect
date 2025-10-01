package com.zidio.job_portal.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.zidio.job_portal.DTO.ApplicationDTO;
import com.zidio.job_portal.DTO.UpdateApplicationStatusDTO;
import com.zidio.job_portal.Service.ApplicationService;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @PostMapping("/apply")
    public ResponseEntity<String> apply(@RequestBody ApplicationDTO dto) {
        applicationService.applyJob(dto);
        return ResponseEntity.ok("Application Submitted");
    }

    @GetMapping("/job/email/{employeeEmail}")
    public ResponseEntity<List<ApplicationDTO>> getByEmployeeEmail(@PathVariable String employeeEmail) {
        return ResponseEntity.ok(applicationService.getByEmployeeEmail(employeeEmail));
    }

    @GetMapping("/job/id/{jobId}")
    public ResponseEntity<List<ApplicationDTO>> getByJobId(@PathVariable Long jobId) {
        return ResponseEntity.ok(applicationService.getByJobId(jobId));
    }

    @PutMapping("/status")
    public ResponseEntity<String> updateApplicationStatus(@RequestBody UpdateApplicationStatusDTO dto) {
        applicationService.updateApplicationStatus(dto);
        return ResponseEntity.ok("Status Updated");
    }
    
    @GetMapping("/count")
    public ResponseEntity<Long> getApplicationCount() {
        return ResponseEntity.ok(applicationService.countApplications());
    }

}
