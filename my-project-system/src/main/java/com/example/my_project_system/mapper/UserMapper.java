package com.example.my_project_system.mapper;

import com.example.my_project_system.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User findByUsername(String username);
    void insert(User user);
    int countByUsername(String username);
    int updateById(User user);
}
