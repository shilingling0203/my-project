package com.example.my_project_system.controller;

import com.example.my_project_system.pojo.LoginRequest;
import com.example.my_project_system.pojo.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
//@CrossOrigin(origins="http://localhost:8080")
public class LoginController {
    @PostMapping("/login")
    public Result<?>login(@RequestBody LoginRequest req){
        if ("admin".equals(req.getUsername())&&"123456".equals(req.getPassword())){
            return Result.success("fake-jwt-token-admin");
        }
        return Result.error("用户名或密码错误");
    }
}
