package com.module.case4.model.course;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.module.case4.model.users.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date startTime;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date endTime;
    @Enumerated(EnumType.STRING)
//    @NaturalId
    private Status status = Status.WAIT;

    @ManyToOne
    @JoinColumn(name = "userTeacher_id")
    private User userTeacher;

    @ManyToOne
    @JoinColumn(name = "userStudent_id")
    private User userStudent;


}
