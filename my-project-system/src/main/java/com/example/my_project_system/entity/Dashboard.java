package com.example.my_project_system.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Dashboard {
    private Integer id;
    private Date statDate;
    private Integer orderCount;
    private BigDecimal salesAmount;
    private Integer stockWarning;

//    新增
    private Integer pv;
    private String userName;
    private String avatar;

}
