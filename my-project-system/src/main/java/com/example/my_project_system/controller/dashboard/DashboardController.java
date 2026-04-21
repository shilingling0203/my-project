package com.example.my_project_system.controller.dashboard;

import com.example.my_project_system.dto.DashboardDTO;
import com.example.my_project_system.entity.util.R;
import com.example.my_project_system.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {
    @Autowired
    private DashboardService dashboardService;
    /*
    * 系统概览
    * */
    @GetMapping("/overview")
    public R<DashboardDTO> overview(){
        return R.ok(dashboardService.getDashboardData());
    }

    /*
    * 新增：访问统计接口
    * */
    @GetMapping("/visit-stats")
    public R<DashboardDTO> visitStats() {
        DashboardDTO vo = dashboardService.getDashboardData();
        return R.ok(vo);
    }
}
