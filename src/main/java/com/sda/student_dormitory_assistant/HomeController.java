package com.sda.student_dormitory_assistant;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String Home(){
        return "Home";
    }

    
}
