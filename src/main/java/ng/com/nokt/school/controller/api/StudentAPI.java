package ng.com.nokt.school.controller.api;

import ng.com.nokt.school.domain.Student;
import ng.com.nokt.school.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StudentAPI {

    @Autowired
    StudentService studentService;

    @RequestMapping("/students")
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllDrones(){
        return ResponseEntity.ok().body(studentService.getAllStudents());
    }

    @PostMapping("/students")
    public ResponseEntity<Student> createDrone(@RequestBody Student student){
        return ResponseEntity.ok().body(studentService.saveStudent(student));
    }
}
