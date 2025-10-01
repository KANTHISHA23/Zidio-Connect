package com.zidio.job_portal.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zidio.job_portal.DTO.JobPostDTO;
import com.zidio.job_portal.Entity.JobPost;
import com.zidio.job_portal.Enum.JobType;
import com.zidio.job_portal.Service.JobPostService;

@RestController
@RequestMapping("/api/jobPosts")
public class JobPostController {

	@Autowired
	private JobPostService jobPostService;
	
	@PostMapping
	public ResponseEntity<JobPost>createJobs(@RequestBody JobPostDTO dto){
      
		return ResponseEntity.ok(jobPostService.createJob(dto));
	}
	
	@GetMapping
	public ResponseEntity<List<JobPost>>getAllJobs(){
		return ResponseEntity.ok(jobPostService.getAllJobs());
	}
	
	@GetMapping("/recruiters/{recruiterEmail}")
	public ResponseEntity<List<JobPost>>getJobByRecruiter(@PathVariable String recruiterEmail){
		return ResponseEntity.ok(jobPostService.getJobByRecruiter(recruiterEmail));
	}
	
	@GetMapping("/search/company/{companyName}")
	public ResponseEntity<List<JobPost>>getJobByCompanyName(@PathVariable String companyName){
		return ResponseEntity.ok(jobPostService.searchJobByCompanyName(companyName));
	}
	
	@GetMapping("search/location/{jobLocation}")
	public ResponseEntity<List<JobPost>>getJobByJobLocation(@PathVariable String jobLocation){
		return ResponseEntity.ok(jobPostService.searchJobByJobLocation(jobLocation));
	}
	
	@GetMapping("search/type/{jobType}")
	public ResponseEntity<List<JobPost>>getJobByJobType(@PathVariable JobType jobType){
		return ResponseEntity.ok(jobPostService.searchJobByJobType(jobType));
	}
	
	@GetMapping("/search/jobtitle/{jobTitle}")
	public ResponseEntity<List<JobPost>>getJobByJobTitle(@PathVariable String jobTitle){
		return ResponseEntity.ok(jobPostService.searchJobByJobTitle(jobTitle));
	}
	
	@GetMapping("/count")
	public ResponseEntity<Long> getJobPostCount() {
	    return ResponseEntity.ok(jobPostService.countJobPosts());
	}

}
