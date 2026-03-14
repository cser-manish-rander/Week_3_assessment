package com.university.entity;

import javax.persistence.*;
import java.util.*;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String courseName;
	private String instructor;

	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	private List<Enrollment> enrollments = new ArrayList<>();

	public Course() {
	}

	public Course(String courseName, String instructor) {
		this.courseName = courseName;
		this.instructor = instructor;
	}

	public int getId() {
		return id;
	}

	public String getCourseName() {
		return courseName;
	}

	public String getInstructor() {
		return instructor;
	}

	public List<Enrollment> getEnrollments() {
		return enrollments;
	}

	public void addEnrollment(Enrollment e) {
		enrollments.add(e);
		e.setCourse(this);
	}

}