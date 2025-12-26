package com.example.demo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class Student {  
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)//
	private int studentId;
	private String name;
	private String course;
	private String email;
	private float marks;
	
	public Student() {
		super();
	}




	public Student(int id, String name, String course, String email, float marks) {
		super();
		this.studentId = id;
		this.name = name;
		this.course = course;
		this.email = email;
		this.marks = marks;
	}




	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public float getMarks() {
		return marks;
	}

	public void setMarks(float marks) {
		this.marks = marks;
	}

}
