package com.example.my_project_system.service;

import com.example.my_project_system.dto.DashboardDTO;
import com.example.my_project_system.entity.Dashboard;
import com.example.my_project_system.mapper.DashboardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {
    /**
     * 获取控制台首页的所有统计数据
     *
     * @return DashboardVO 控制台视图对象
     */
    @Autowired
    private DashboardMapper dashboardMapper;

    public Dashboard getTodayStats(){
        return dashboardMapper.selectTodayStats();
    }

}
