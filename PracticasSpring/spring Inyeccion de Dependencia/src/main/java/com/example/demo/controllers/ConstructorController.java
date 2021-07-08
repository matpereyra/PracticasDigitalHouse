package com.example.demo.controllers;

import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/constructor")
public class ConstructorController{

    UserService userService;

    public ConstructorController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/test")
    public String testID(){
        return this.getClass().getSimpleName() + " : " + userService.responseID() + userService.toString();
    }
}
