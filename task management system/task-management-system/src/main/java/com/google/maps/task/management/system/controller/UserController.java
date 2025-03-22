//package com.google.maps.task.management.system.controller;
//
//import com.google.maps.task.management.system.entity.UserEntity;
//import com.google.maps.task.management.system.service.UserService;
//import org.apache.catalina.User;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import java.util.List;
//
//public class UserController
//{
//    private UserService userService;
//    public UserController(UserService userService)
//    {
//        this.userService=userService;
//    }
//    @GetMapping("/add")
//    public String add()
//    {
//        return "add";
//    }
//    @GetMapping("/task")
//    public List<UserEntity> task()
//    {
//            return this.userService.GetAllUsers();
//    }
//}