package com.example.my_project_system.mapper;

import com.example.my_project_system.entity.User;

public interface UserMapper {
    User findByUsername(String username);
    void insert(User user);
}
