package ng.com.nokt.school.services;

import ng.com.nokt.school.domain.Courses;

import java.util.List;

public interface CoursesService {
    List<Courses> getAllStudents();
    Courses saveCourse(Courses course);
    Courses getCourseById(long id);

    void deleteCourseById(long id);
}
