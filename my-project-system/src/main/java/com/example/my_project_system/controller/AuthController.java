package com.example.my_project_system.controller;

import com.example.my_project_system.dto.LoginDTO;
import com.example.my_project_system.dto.RegisterDTO;
import com.example.my_project_system.dto.Result;
import com.example.my_project_system.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result<String> login(@RequestBody LoginDTO loginDTO) {
        String token = userService.login(loginDTO);
        return Result.success(token);
    }

    @PostMapping("/register")
    public Result<String> register(@RequestBody RegisterDTO registerDTO) {
        String msg = userService.register(registerDTO);
        return Result.success(msg);
    }

    @PostMapping("/logout")
    public Map<String,Object> logout(HttpServletRequest request){
        return Map.of(
                "code",200,
                "msg","退出成功"
        );
    }

}
