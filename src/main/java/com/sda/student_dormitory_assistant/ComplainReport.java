package com.sda.student_dormitory_assistant;

<<<<<<< HEAD
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor

public class ComplainReport {
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   private Long id;


   @Size(min = 5, max = 20, message="student name must be between 5 and 20")
   private String studentName;
   @NotBlank(message = "studentID name is required")
   private String studentID;
   @Digits(integer= 3 ,fraction = 0, message = "block number must be a number")
   private String studentBlockNO;
   @Digits(integer= 3 ,fraction = 0, message = "dorm number must be a number ")
   private String studentDormNO;
   @Size(min = 10, max = 100, message="write your complain properly")
=======
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class ComplainReport {
   @NotBlank(message = "student name is required")
   private String studentName;
   @NotBlank(message = "studentID name is required")
   private String studentID;
   @NotBlank(message = "building block is required")
   private String studentBlockNO;
   @NotBlank(message = "Dormno is required")
   private String studentDormNO;
   @NotBlank(message = "write your complain")
>>>>>>> 73f4ef6d6f3fe703c4a557902b6b2c991d8d0073
   private String studentComplain;
   
   }

