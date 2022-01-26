package com.sda.student_dormitory_assistant.security;

import com.sda.student_dormitory_assistant.security.User.Role;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;


@Controller
@AllArgsConstructor
@RequestMapping("/register")
public class RegistrationController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @GetMapping
    public String registerForm() {
        return "registration";
    }

    @PostMapping
    public String processRegistration(@ModelAttribute RegistrationForm form) {
        var user = form.toUser(passwordEncoder);
        user.setRole(Role.Student);
        userRepository.save(user);
        return "redirect:/login";
    }
}

