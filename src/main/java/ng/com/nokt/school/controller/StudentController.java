package ng.com.nokt.school.controller;

import ng.com.nokt.school.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("allStudent", studentService.getAllStudents());
        return "index";
    }
}
