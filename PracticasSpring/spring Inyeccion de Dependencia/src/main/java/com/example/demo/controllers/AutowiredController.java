package com.example.demo.controllers;

import com.example.demo.services.UserService;
import com.example.demo.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autowired")
public class AutowiredController{

    @Autowired()
    UserService userService;

    @GetMapping("/test")
    public String testID(){
        return this.getClass().getSimpleName() + " : " + userService.responseID() + userService.toString();
    }
}
