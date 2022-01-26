package com.sda.student_dormitory_assistant;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
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
   private String studentComplain;

   @Enumerated(EnumType.STRING) 
   private Validity valid = Validity.NONE;
    
    public static enum Validity{
        VALID,INVALID,NONE
    }

    @Enumerated(EnumType.STRING) 
    private IsAddressed address = IsAddressed.UNADDRESSED;

    public static enum IsAddressed{
        ADDRESSED,UNADDRESSED
    }
      
   }
