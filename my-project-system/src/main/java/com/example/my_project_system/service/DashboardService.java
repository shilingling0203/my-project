package com.example.my_project_system.service;

import com.example.my_project_system.dto.DashboardDTO;

public interface DashboardService {
    /**
     * 获取控制台首页的所有统计数据
     *
     * @return DashboardVO 控制台视图对象
     */
    DashboardDTO getDashboardData();
}
