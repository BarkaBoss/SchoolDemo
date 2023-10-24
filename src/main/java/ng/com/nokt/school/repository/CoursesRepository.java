package ng.com.nokt.school.repository;

import ng.com.nokt.school.domain.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesRepository extends JpaRepository<Courses, Long> {
    Courses findCoursesByCourseCode(String courseCode);
}
