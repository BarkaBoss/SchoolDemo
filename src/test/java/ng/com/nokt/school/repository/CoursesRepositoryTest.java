package ng.com.nokt.school.repository;

import ng.com.nokt.school.domain.Courses;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CoursesRepositoryTest {

    @Autowired
    CoursesRepository coursesRepository;

    @Test
    void getListOfAllCourses(){
        List<Courses> courses = coursesRepository.findAll();
        assertThat(courses.size()).isEqualTo(5);
    }
}