package com.example.my_project_system.service;

import com.example.my_project_system.dto.LoginDTO;
import com.example.my_project_system.dto.RegisterDTO;

public interface UserService {
    String login(LoginDTO dto);
    void register(RegisterDTO dto);
}
