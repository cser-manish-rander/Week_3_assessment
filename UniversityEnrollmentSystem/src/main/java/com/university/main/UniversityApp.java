package com.university.main;

import javax.persistence.*;
import com.university.entity.*;

import java.time.LocalDate;
import java.util.Scanner;

public class UniversityApp {

public static void main(String[] args) {

EntityManagerFactory emf = Persistence.createEntityManagerFactory("universityPU");
EntityManager em = emf.createEntityManager();
EntityTransaction tx = em.getTransaction();

Scanner sc = new Scanner(System.in);

System.out.println("Enter courseName instructor studentName enrollmentDate");

String courseName = sc.next();
String instructor = sc.next();
String student = sc.next();
String date = sc.next();

tx.begin();

Course course = new Course(courseName,instructor);

Enrollment enrollment = new Enrollment(
student,
LocalDate.parse(date)
);

course.addEnrollment(enrollment);

em.persist(course);

tx.commit();

System.out.println("Course added successfully");

System.out.println("Enter Course ID to search");

int id = sc.nextInt();

TypedQuery<Course> query = em.createQuery(
"SELECT c FROM Course c WHERE c.id = :id",Course.class);

query.setParameter("id", id);

Course c = query.getSingleResult();

System.out.println("ID: "+c.getId());
System.out.println("Course: "+c.getCourseName());
System.out.println("Instructor: "+c.getInstructor());

System.out.println("Enrollments:");

for(Enrollment e : c.getEnrollments()){

System.out.println("Student Name: "+e.getStudentName());
System.out.println("Enrollment Date: "+e.getEnrollmentDate());

}

em.close();
emf.close();

}
}