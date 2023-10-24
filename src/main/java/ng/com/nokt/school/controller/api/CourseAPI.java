package ng.com.nokt.school.controller.api;

import ng.com.nokt.school.domain.Courses;
import ng.com.nokt.school.services.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CourseAPI {

    @Autowired
    CoursesService coursesService;

    @RequestMapping("/courses")
    @GetMapping("/courses")
    public ResponseEntity<List<Courses>> getAllCourses(){
        return ResponseEntity.ok().body(coursesService.getAllCourses());
    }

    @PostMapping("/courses")
    public ResponseEntity<Courses> saveCourse(@RequestBody Courses course){
        return ResponseEntity.ok().body(coursesService.saveCourse(course));
    }

}
