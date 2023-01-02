package org.crystal.tacocloud.tacos.controller;

import org.crystal.tacocloud.tacos.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("index")
    public String home(){
        return "home";
    }

    @GetMapping("login")
    public String login(){
        return "login";
    }

}
