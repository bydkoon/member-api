package com.asnisum.api.auth;

import com.asnisum.api.member.entity.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    // handler method to handle home page request
    @GetMapping("/index")
    public String home(){
        return "index";
    }

    // handler method to handle user registration form request
    @GetMapping("/signUp")
    public String showRegistrationForm(Model model){
        // create model object to store form data
//        Member member = new Member();
//        model.addAttribute("member", member);
        return "signUp";
    }
}
