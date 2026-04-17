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

    @Override
    public String login(LoginDTO dto){
        User user=userMapper.findByUsername(dto.getUsername());
        if (user==null){
            throw new RuntimeException("用户不存在");
        }
        if (!passwordEncoder.matches(dto.getPassword(),user.getPassword())){
            throw new RuntimeException("密码错误");
        }
        return JwtUtil.generateToken(user.getUsername());
    }

    @Override
    public void register(RegisterDTO dto){
        User exit=userMapper.findByUsername(dto.getUsername());
        if (exit!=null){
            throw new RuntimeException("用户名已存在");
        }
        User user=new User();
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        userMapper.insert(user);
    }
}
