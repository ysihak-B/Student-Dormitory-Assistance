package com.sda.student_dormitory_assistant;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.sda.student_dormitory_assistant.ComplainReport.Validity;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@SessionAttributes("complainReport")
public class ValidtyController {

    private final ComplainRepository repository;

    @GetMapping("/validity")
    public String showValidity(Model model) {

        Validity[] types = Validity.values();

        List<ComplainReport> complainReport = new ArrayList<>();
        this.repository.findAll().forEach(i -> complainReport.add(i));

        for (Validity t : types) {
            model.addAttribute(t.toString().toLowerCase(), filterByValidity(complainReport, t));
        }
        return "validity";
    }
    private Iterable<ComplainReport> filterByValidity(List<ComplainReport> complainReport, Validity validation) {
        return complainReport.stream()
                .filter(i -> i.getValid().equals(validation))
                .collect(Collectors.toList());
    }
}