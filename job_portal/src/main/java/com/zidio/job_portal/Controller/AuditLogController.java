package com.zidio.job_portal.Controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zidio.job_portal.DTO.AuditLogDTO;
import com.zidio.job_portal.Service.AuditLogService;

@RestController
@RequestMapping("/api/auditLogs")
public class AuditLogController {

	@Autowired
	private AuditLogService auditLogService;
	
	@PostMapping
	public ResponseEntity<String>getlogAction(@RequestBody AuditLogDTO dto){
		dto.setTimeStamp(LocalDateTime.now());
		auditLogService.logAction(dto);
		return ResponseEntity.ok("Log is Saved");
	}
	
	@GetMapping("/log/module/{module}")
	public ResponseEntity<List<AuditLogDTO>>getLogsByModule(@PathVariable String module){
		return ResponseEntity.ok(auditLogService.getLogsByModule(module));
	}
	
	@GetMapping("/log/actor/{actor}")
	public ResponseEntity<List<AuditLogDTO>>getLogsByActor(@PathVariable String actor){
		return ResponseEntity.ok(auditLogService.getLogsByActor(actor));
	} 
}
