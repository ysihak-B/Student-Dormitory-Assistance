package com.sda.student_dormitory_assistant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;

import com.sda.student_dormitory_assistant.security.User;
import org.springframework.ui.Model;


@Controller
@RequiredArgsConstructor
public class ProfileController {

    @Autowired
    private UserService service;

    @GetMapping("/profile")
    public String viewProfile(@AuthenticationPrincipal User user, Model model){
        model.addAttribute("user", user);
        return "profile";
    }

    // @GetMapping("/profile")
    // public String viewProfile(@AuthenticationPrincipal User user, Model model){
    //     model.addAttribute("user", user);
    //     return "profile";
    // }

    @RequestMapping("/editprofile/{id}")
    public ModelAndView showEditProfilePage(@PathVariable(name = "id") Long id , @AuthenticationPrincipal User user , Model model) {
        model.addAttribute("user", user);
        ModelAndView mav = new ModelAndView("edit_Profile");
        User myProfile = service.get(id);
            mav.addObject("myProfile", myProfile);
                return mav;
}
    @RequestMapping(value = "/change", method = RequestMethod.POST)
    public String saveProfile(@ModelAttribute("myProfile") User user) {
        service.save(user);
                return "redirect:/profile";
}

@RequestMapping("/deleteaccount/{id}")
    public String deleteAccount(@PathVariable(name = "id") Long id) {
        service.delete(id);
            return "redirect:/"; 
}
}
