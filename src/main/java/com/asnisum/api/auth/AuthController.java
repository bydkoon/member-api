package com.asnisum.api.auth;

import com.asnisum.api.member.entity.Member;
import com.asnisum.api.member.repository.MemberRepository;
import com.asnisum.api.member.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class AuthController {
    // handler method to handle home page request

    private final MemberRepository memberRepository;
    @GetMapping("/index")
    public String home(){
        return "index";
    }

    // handler method to handle user registration form request

    @GetMapping("/register")
    public String showRegistrationForm(){
        // create model object to store form data
        return "register";
    }
    @GetMapping("/process_register")
    public String processRegister() {
        return "register_success";
    }
}
