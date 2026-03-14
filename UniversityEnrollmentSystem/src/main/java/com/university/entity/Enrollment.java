package com.university.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Enrollment {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

private String studentName;

private LocalDate enrollmentDate;

@ManyToOne
@JoinColumn(name="course_id")
private Course course;

public Enrollment(){}

public Enrollment(String studentName,LocalDate enrollmentDate){
this.studentName=studentName;
this.enrollmentDate=enrollmentDate;
}

public int getId(){
return id;
}

public String getStudentName(){
return studentName;
}

public LocalDate getEnrollmentDate(){
return enrollmentDate;
}

public void setEnrollmentDate(LocalDate enrollmentDate){
this.enrollmentDate=enrollmentDate;
}

public void setCourse(Course course){
this.course=course;
}

}