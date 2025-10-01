package com.zidio.job_portal.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zidio.job_portal.DTO.AuditLogDTO;
import com.zidio.job_portal.Entity.AuditLog;
import com.zidio.job_portal.Repository.AuditLogRepository;

@Service
public class AuditLogService {

	@Autowired
	private AuditLogRepository auditLogRepository;
	
	public String logAction(AuditLogDTO dto) {
		AuditLog log= new AuditLog();
		
		log.setActor(dto.actor);
		log.setAction(dto.action);
		log.setId(dto.id);
		log.setTarget(dto.target);
		log.setTimeStamp(dto.timeStamp);
		log.setModule(dto.module);
		
		auditLogRepository.save(log);
		return "Audit Log Saved";
	}
	
	public List<AuditLogDTO>getLogsByModule(String module){
		return auditLogRepository.findByModule(module).stream().map(this::maptoDTO).collect(Collectors.toList());
	}
	
	public List<AuditLogDTO>getLogsByActor(String actor){
		return auditLogRepository.findByActor(actor).stream().map(this::maptoDTO).collect(Collectors.toList());
	}
	
	private AuditLogDTO maptoDTO(AuditLog log) {
		AuditLogDTO dto= new AuditLogDTO();
		
		dto.setId(log.getId());
		dto.setActor(log.getActor());
		dto.setAction(log.getAction());
		dto.setModule(log.getModule());
		dto.setTarget(log.getTarget());
		dto.setTimeStamp(log.getTimeStamp());
		
		return dto;
	}
}
