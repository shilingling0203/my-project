package com.example.my_project_system.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private LocalDateTime createTime;
    private String nickname;
    private String deptName;
    private String roleName;
}
