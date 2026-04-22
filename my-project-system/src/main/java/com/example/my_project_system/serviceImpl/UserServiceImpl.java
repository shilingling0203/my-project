package com.example.my_project_system.serviceImpl;

import com.example.my_project_system.dto.LoginDTO;
import com.example.my_project_system.dto.RegisterDTO;
import com.example.my_project_system.entity.User;
import com.example.my_project_system.mapper.UserMapper;
import com.example.my_project_system.security.JwtUtil;
import com.example.my_project_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // ✅ 构造器注入（最稳）
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    @Override
    public String login(LoginDTO dto){
        User user = userMapper.findByUsername(dto.getUsername());
        if (user == null) {
            throw new RuntimeException("用户名或密码错误");
        }

        boolean matches = passwordEncoder.matches(
                dto.getPassword(),
                user.getPassword()
        );

        if (!matches) {
            throw new RuntimeException("用户名或密码错误");
        }

        return "mock-jwt-token";
    }

    @Override
    public String register(RegisterDTO dto){
//        1.校验密码
        if (!dto.getPassword().equals(dto.getConfirmPassword())){
            throw new RuntimeException("两次密码不一致");
        }
//        2.校验用户名
        if (userMapper.countByUsername(dto.getUsername())>0){
            throw new RuntimeException("用户名已存在");
        }
//        3.保存用户
        User user=new User();
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        userMapper.insert(user);
        return "注册成功";
    }
}
