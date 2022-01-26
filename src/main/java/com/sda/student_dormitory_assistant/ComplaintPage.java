package com.sda.student_dormitory_assistant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;


@Entity
@Data
public class ComplaintPage {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private Long id ;

    @Column(name = "studentName")
    private String studentName;

    @Column(name="studentID")
    private String studentID;

    @Column(name="studentBlockNO")
    private String studentBlockNO;

    @Column(name = "studentDormNO")
    private String studentDormNO;

    @Column(name = "studentComplain")
    private String studentComplain;

    @Column(name = "validity")
    private String validity;

}
