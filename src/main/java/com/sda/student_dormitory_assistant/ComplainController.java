package com.sda.student_dormitory_assistant;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import lombok.RequiredArgsConstructor;


@Controller
@SessionAttributes("complainReport")
@RequiredArgsConstructor
public class ComplainController {

    private final ComplainRepository repository;
    @GetMapping("/complains/current")
    public String reportForm(Model model) {
        model.addAttribute("complainReport", new ComplainReport());
        return "Reportcomplaints";
    }

    @PostMapping("/complains")
    public String processReport(@Valid ComplainReport complain, Errors errors, SessionStatus status) {

        if (errors.hasErrors()) {
            return "Reportcomplaints";
        }

        this.repository.save(complain);
        status.setComplete();
        return "redirect:/complaint";
    }
}
