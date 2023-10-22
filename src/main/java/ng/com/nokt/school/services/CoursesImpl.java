package ng.com.nokt.school.services;

import ng.com.nokt.school.domain.Courses;
import ng.com.nokt.school.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoursesImpl implements CoursesService{

    @Autowired
    CoursesRepository coursesRepository;
    @Override
    public List<Courses> getAllStudents() {
        return coursesRepository.findAll();
    }

    @Override
    public Courses saveCourse(Courses course) {
        Optional<Courses> optional = Optional.ofNullable(coursesRepository.findCoursesByCourseCode());

        if(optional.isPresent()){
            throw new RuntimeException("Course is Already Present");
        }else {
            coursesRepository.save(course);
        }

        return course;
    }

    @Override
    public Courses getCourseById(long id) {
        Optional<Courses> optional = coursesRepository.findById(id);

        Courses courses = null;
        if(optional.isPresent()){
            courses = optional.get();
        }else {
            throw new RuntimeException("Course not registered");
        }

        return courses;
    }

    @Override
    public void deleteCourseById(long id) {
        coursesRepository.deleteById(id);
    }
}
