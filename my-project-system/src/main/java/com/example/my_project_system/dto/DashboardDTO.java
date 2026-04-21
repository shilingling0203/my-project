package com.example.my_project_system.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class DashboardDTO implements Serializable {
    private static final long serialVersionUID=1L;

//    今日订单数
    private Integer orderToday;

//    本月销售额
    private BigDecimal salesMonth;

//    库存预警数量
    private Integer stockWarning;

//    待办任务数量
    private Integer todoCount;

//    当前在线人数
    private Integer onlineCount;

    /** ✅ 新增：今日访问 */
    private Integer todayCount;

    /** ✅ 新增：累计访问 */
    private Integer totalCount;
}
