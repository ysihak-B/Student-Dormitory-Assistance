package com.sda.student_dormitory_assistant;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ReportController {

    @GetMapping("/complains/current")
    public String reportForm(Model model) {
        model.addAttribute("complainReport", new ComplainReport());
        return "Reportcomplaints";
    }

    @PostMapping("/complains")
    public String processReport(@Valid ComplainReport complain, Errors errors) {

        if (errors.hasErrors()) {
            return "Reportcomplaints";
        }

        log.info("Order submitted: " + complain);
        return "redirect:/";
    }
}
