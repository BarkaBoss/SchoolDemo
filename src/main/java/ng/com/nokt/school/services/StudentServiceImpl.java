package ng.com.nokt.school.services;

import ng.com.nokt.school.domain.Courses;
import ng.com.nokt.school.domain.Student;
import ng.com.nokt.school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        studentRepository.save(student);
        return student;
    }

    @Override
    public Student getStudentById(long id) {
        Optional<Student> optional = studentRepository.findById(id);

        Student student = null;
        if (optional.isPresent()){
            student = optional.get();
        }else {
            throw new RuntimeException("Student with ID "+id+" not found");
        }

        return student;
    }

    @Override
    public Student updateStudent(Student student) {
        Optional<Student> optional = studentRepository.findById(student.getId());

        if (optional.isPresent()){
            Student updateStudent = new Student();
            updateStudent.setId(student.getId());
            updateStudent.setDateOfBirth(student.getDateOfBirth());
            updateStudent.setEmail(student.getEmail());
            updateStudent.setFirstName(student.getFirstName());
            updateStudent.setLastName(student.getLastName());
            updateStudent.setStateOfOrigin(student.getStateOfOrigin());
            updateStudent.setNationality(student.getNationality());
            updateStudent.setCourses(student.getCourses());

            studentRepository.save(updateStudent);
            return updateStudent;
        }else {
            throw new RuntimeException("Student Does not Exist ==> " + student.getId());
        }
    }

    @Override
    public void deleteStudentById(long id) {
        studentRepository.deleteById(id);
    }
}
