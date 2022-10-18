package com.asnisum.api.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    @GetMapping("/index")
    public String home(){
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(){
        return "register";
    }
    @GetMapping("/process_register")
    public String processRegister() {
        return "register_success";
    }
}
