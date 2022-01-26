package com.sda.student_dormitory_assistant;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.sda.student_dormitory_assistant.ComplainReport.IsAddressed;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@SessionAttributes("complainReport")
public class IsAddressedController {

    private final ComplainRepository repository;

    @GetMapping("/isAddressed")
    public String showValidity(Model model) {

        IsAddressed[] types = IsAddressed.values();

        List<ComplainReport> complainReport = new ArrayList<>();
        this.repository.findAll().forEach(i -> complainReport.add(i));

        for (IsAddressed t : types) {
            model.addAttribute(t.toString().toLowerCase(), filterByIsAddressed(complainReport, t));
        }
        return "isaddressed";
    }
    private Iterable<ComplainReport> filterByIsAddressed(List<ComplainReport> complainReport, IsAddressed address) {
        return complainReport.stream()
                .filter(i -> i.getAddress().equals(address))
                .collect(Collectors.toList());
    }
}