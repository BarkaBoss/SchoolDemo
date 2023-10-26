package ng.com.nokt.school.controller.api;

import ng.com.nokt.school.domain.Courses;
import ng.com.nokt.school.domain.Student;
import ng.com.nokt.school.services.CoursesService;
import ng.com.nokt.school.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentAPI {

    @Autowired
    StudentService studentService;
    @Autowired
    CoursesService coursesService;

    @RequestMapping("/students")
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(){
        return ResponseEntity.ok().body(studentService.getAllStudents());
    }

    @RequestMapping("/students/{id}")
    @GetMapping
    public ResponseEntity<Student> getStudentById(@PathVariable long id){
        return ResponseEntity.ok().body(studentService.getStudentById(id));
    }

    @PostMapping("/students")
    public ResponseEntity<Student> createDrone(@RequestBody Student student){
        return ResponseEntity.ok().body(studentService.saveStudent(student));
    }

    @PostMapping("/students/{studentId}/course/{courseId}")
    public ResponseEntity<Student> addCourseToStudent(@PathVariable long studentId, @PathVariable long courseId){

        Courses courses = coursesService.getCourseById(courseId);
        Student student = studentService.getStudentById(studentId);

        List<Courses> coursesList = student.getCourses();
        int totalUnits = 0;

        for (Courses course : coursesList){
            totalUnits += course.getCreditUnit();
        }

        if (totalUnits > 24){
            ResponseEntity.ok().body("You can not have more than 24 units");
            throw new RuntimeException("You can not have more than 24 units add this will be: "+totalUnits);
        }else{
            student.getCourses().add(courses);
            return ResponseEntity.ok().body(studentService.updateStudent(student));
        }
    }
}
