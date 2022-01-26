package com.sda.student_dormitory_assistant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class ComplaintPageController {
    
    @Autowired
    private ComplaintPageService service;
    
    @RequestMapping("/complaint")
    public String viewProfilePage(Model model){
        List<ComplainReport> listProfile = service.listAll();
            model.addAttribute("listProfile", listProfile);
                return "complaint";
    }

    @RequestMapping("/new")
    public String showNewCompalaintPage(Model model) {
        ComplainReport complainReport = new ComplainReport();
            model.addAttribute("complainReport", complainReport);
                return "Reportcomplaints";
}
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditCompalintPage(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_complain");
        ComplainReport complainReport = service.get(id);
            mav.addObject("complainReport", complainReport);
                return mav;
}
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveComplain(@ModelAttribute("complainReport") ComplainReport complainReport ) {
        service.save(complainReport);
                return "redirect:/complaint";
}
    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        service.delete(id);
            return "redirect:/complaint";       
}
}



    

