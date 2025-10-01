package com.zidio.job_portal.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zidio.job_portal.DTO.ApplicationTrackDTO;
import com.zidio.job_portal.DTO.DashBoardDTO;
import com.zidio.job_portal.Service.AnalyticService;


@RestController
@RequestMapping("/api/dashboard")
public class AnalyticController {

    @Autowired
    private AnalyticService analyticService;

    // 📊 Summary counts (employees, recruiters, jobs, apps, admins, payments)
    @GetMapping("/summary")
    public ResponseEntity<DashBoardDTO> getSummary() {
        return ResponseEntity.ok(analyticService.getSummary());
    }

    // 📈 Weekly applications trend
    @GetMapping("/applications/weekly")
    public ResponseEntity<List<ApplicationTrackDTO>> getWeeklyTrackers() {
        return ResponseEntity.ok(analyticService.getWeeklyApplicationsTracker());
    }
}
