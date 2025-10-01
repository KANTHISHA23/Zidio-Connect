package com.zidio.job_portal.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zidio.job_portal.DTO.ApplicationDTO;
import com.zidio.job_portal.DTO.UpdateApplicationStatusDTO;
import com.zidio.job_portal.Entity.Application;
import com.zidio.job_portal.Enum.ApplicationStatus;
import com.zidio.job_portal.Repository.ApplicationRepository;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    public ApplicationDTO applyJob(ApplicationDTO dto) {
        Application app = new Application();
        app.setJobId(dto.getJobId());
        app.setEmployeeEmail(dto.getEmployeeEmail());
        app.setRecruiterEmail(dto.getRecruiterEmail());
        app.setStatus(ApplicationStatus.APPLIED);
        app.setResumeURL(dto.getResumeURL());

        applicationRepository.save(app);
        return mapToDTO(app);
    }

    public List<ApplicationDTO> getByEmployeeEmail(String employeeEmail) {
        return applicationRepository.findByEmployeeEmail(employeeEmail)
                .stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public List<ApplicationDTO> getByRecruiterEmail(String recruiterEmail) {
        return applicationRepository.findByRecruiterEmail(recruiterEmail)
                .stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public List<ApplicationDTO> getByJobId(Long jobId) {
        return applicationRepository.findByJobId(jobId)
                .stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public ApplicationDTO updateApplicationStatus(UpdateApplicationStatusDTO dto) {
        Optional<Application> optional = applicationRepository.findById(dto.getId());

        if (!optional.isPresent()) {
            throw new RuntimeException("Application not found");
        }

        Application app = optional.get();
        app.setStatus(dto.getStatus());

        applicationRepository.save(app);

        return mapToDTO(app);
    }

    private ApplicationDTO mapToDTO(Application app) {
        return new ApplicationDTO(
            app.getId(),
            app.getJobId(),
            app.getEmployeeEmail(),
            app.getStatus(),
            app.getRecruiterEmail(),
            app.getResumeURL()
        );
    }
    
    public long countApplications() {
        return applicationRepository.count();
    }

    
}
