package com.example.jiekou1.controller;

import com.example.jiekou1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

//对外接口
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {

   // @Resource
   // UserMapper userMapper;

    @Autowired
    private UserService userService;

    /**
    @GetMapping
    public List<User> getUser(){
        return userService.findAll();
    }
    **/

    @GetMapping
    public Map getData(){
        return userService.getData();
    }
}
