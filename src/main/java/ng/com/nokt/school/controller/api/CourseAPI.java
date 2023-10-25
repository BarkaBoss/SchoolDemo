package ng.com.nokt.school.controller.api;

import ng.com.nokt.school.domain.Courses;
import ng.com.nokt.school.services.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/courses/{id}")
    public ResponseEntity<Courses> updateCourse(@RequestBody Courses courses, @PathVariable long id){
        return ResponseEntity.ok().body(coursesService.updateCourse(courses, id));
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<Courses> getCourseById(@PathVariable long id){
        return ResponseEntity.ok().body(coursesService.getCourseById(id));
    }

    @DeleteMapping("/courses/{id}")
    public HttpStatus deleteMedicine(@PathVariable long id){
        coursesService.deleteCourseById(id);
        return HttpStatus.OK;
    }
}
