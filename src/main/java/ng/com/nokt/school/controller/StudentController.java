package ng.com.nokt.school.controller;

import ng.com.nokt.school.domain.Student;
import ng.com.nokt.school.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("allStudent", studentService.getAllStudents());
        return "index";
    }

    @GetMapping("/showAddStudentForm")
    public String showAddStudentForm(Model model){

        Student student = new Student();
        model.addAttribute("student",student);
        return "new_student";
    }

    @PostMapping("/saveStudent")
    public String saveEmployee(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable(value = "id") long id, Model model){

        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "update_student";
    }

    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable long id){

        this.studentService.deleteStudentById(id);
        return "redirect:/";
    }
}
