package com.example.my_project_system.controller;

import com.example.my_project_system.dto.LoginDTO;
import com.example.my_project_system.dto.RegisterDTO;
import com.example.my_project_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Map<String,Object> login(@RequestBody LoginDTO dto){
        String token=userService.login(dto);
        return Map.of("code",200,"token",token);
    }

    @PostMapping("/register")
    public Map<String,Object> register(@RequestBody RegisterDTO dto){
        userService.register(dto);
        return Map.of("code",200,"msg","注册成功");
    }
}
