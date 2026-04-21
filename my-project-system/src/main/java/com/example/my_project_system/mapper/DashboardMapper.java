package com.example.my_project_system.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;


@Mapper
public interface DashboardMapper {
    Integer countTodayOrder();
    BigDecimal sumMonthSales();
    Integer countStockWarning();
    Integer countTodo();
    Integer countOnlineUser();
}
