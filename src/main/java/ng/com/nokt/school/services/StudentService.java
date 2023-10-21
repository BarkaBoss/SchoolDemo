package ng.com.nokt.school.services;

import ng.com.nokt.school.domain.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    void saveStudent (Student student);
    Student getStudentById(long id);
    void deleteStudentById(long id);
}
