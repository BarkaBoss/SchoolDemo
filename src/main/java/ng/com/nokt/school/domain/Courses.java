package ng.com.nokt.school.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String courseTitle;

    private String courseCode;

    private int creditUnit;

    public Courses() {
    }

    public Courses(String courseTitle, String courseCode, int creditUnit) {
        this.courseTitle = courseTitle;
        this.courseCode = courseCode;
        this.creditUnit = creditUnit;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public int getCreditUnit() {
        return creditUnit;
    }

    public void setCreditUnit(int creditUnit) {
        this.creditUnit = creditUnit;
    }
}
