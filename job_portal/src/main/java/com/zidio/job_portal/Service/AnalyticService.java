package com.zidio.job_portal.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.zidio.job_portal.DTO.ApplicationTrackDTO;
import com.zidio.job_portal.DTO.DashBoardDTO;



@Service
public class AnalyticService {

    @Autowired
    private RestTemplate restTemplate;

    // 📊 Collect summary data from microservices
    public DashBoardDTO getSummary() {
        DashBoardDTO dto = new DashBoardDTO();

        dto.setTotalEmployees(1000);
		dto.setTotalRecruiters(500);
		dto.setTotalJobs(400);
		dto.setTotalApplications(5000);
		
		return dto;
    }

    // 📈 Weekly application tracker (dummy/random values for now)
    public List<ApplicationTrackDTO> getWeeklyApplicationsTracker() {
        List<ApplicationTrackDTO> tracker = new ArrayList<>();

        for (int i = 6; i >= 0; i--) {
            ApplicationTrackDTO dto = new ApplicationTrackDTO();
            dto.setDate(LocalDate.now().minusDays(i).toString());
            dto.setApplications(50 + (long) (Math.random() * 100));
            tracker.add(dto);
        }
        return tracker;
    }
}
