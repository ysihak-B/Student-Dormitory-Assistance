package com.sda.student_dormitory_assistant;

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
   private String studentComplain;
   
   }

