package ng.com.nokt.school.repository;

import ng.com.nokt.school.domain.Courses;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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

    @Transactional
    @Rollback
    @Test
    void saveNewCourse(){
        Courses course = Courses.builder()
                .courseTitle("Mobile Dev")
                .creditUnit(2)
                .courseCode("IFT411").build();

        Courses newCourse = coursesRepository.save(course);
        coursesRepository.flush();

        assertThat(newCourse).isNotNull();
        assertThat(newCourse.getId()).isNotNull();
    }

    @Test
    void testUpdateCourse(){
        Courses courses = coursesRepository.findAll().get(0);
        Courses updateCourse = Courses.builder()
                .id(courses.getId())
                .courseTitle("Java Java Bills")
                .courseCode("CMP725").build();

        Courses newCourse = coursesRepository.save(updateCourse);
        coursesRepository.flush();
        assertThat(newCourse).isNotNull();
        assertThat(newCourse.getId()).isEqualTo(courses.getId());
        assertThat(newCourse.getCourseTitle()).isEqualTo(updateCourse.getCourseTitle());
    }
}