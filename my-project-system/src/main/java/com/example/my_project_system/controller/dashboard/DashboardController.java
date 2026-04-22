package com.example.my_project_system.controller.dashboard;

import com.example.my_project_system.dto.DashboardDTO;
import com.example.my_project_system.entity.Dashboard;
import com.example.my_project_system.entity.util.R;
import com.example.my_project_system.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {
    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/stats")
    public Map<String,Object>today(){
        Dashboard data=dashboardService.getTodayStats();
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("data", data);
        return result;

    }

}
