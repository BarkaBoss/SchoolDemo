package ng.com.nokt.school.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
//@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "courses")
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String courseTitle;

    private String courseCode;

    private int creditUnit;

}
