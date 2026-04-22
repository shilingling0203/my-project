package com.example.my_project_system.controller;

import com.example.my_project_system.dto.LoginDTO;
import com.example.my_project_system.dto.Result;
import com.example.my_project_system.service.UserService;
import com.example.my_project_system.serviceImpl.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
//@CrossOrigin(origins="http://localhost:8080")
public class LoginController {
//    UserService userService=new UserServiceImpl();
//    @PostMapping("/login")
//    public Result<String>login(@RequestBody LoginDTO req){
//        String token = userService.login(req);
//        return Result.success(token);
//    }
}
