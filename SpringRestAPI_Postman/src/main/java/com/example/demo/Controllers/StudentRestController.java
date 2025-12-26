package com.example.demo.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Student;

@RestController
@RequestMapping("/students")
public class StudentRestController {
	
	private List<Student> studentList =new ArrayList<>();

	
	@PostMapping
	public String addStudent(@RequestBody Student student) {
		studentList.add(student);
		return "Student added Successfully";
	}
	
	@GetMapping
	public List<Student> viewStudents(){
		return studentList;
	}
	
	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable int id) {
		for(Student student:studentList) {
			if(student.getStudentId()==id) {
				return student;
			}
		}return null;
		
	}
	
	@PutMapping("/{id}")
	public String updatStudent(@PathVariable int id,@RequestBody Student updateStudent) {
		
		for(Student student:studentList) {
			if(student.getStudentId()==id) {
				student.setName(updateStudent.getName());
				student.setCourse(updateStudent.getCourse());
				student.setEmail(updateStudent.getEmail());
				student.setMarks(updateStudent.getMarks());
				return "Student updated Successfully";
			}
		}
		return "Student not found";
		
	}
	
	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable int id) {
		Student studentToRemove =null;
		
		for(Student student:studentList) {
			if(student.getStudentId()==id) {
				studentToRemove = student;
				break;
			}
		}
		if(studentToRemove !=null) {
			studentList.remove(studentToRemove);
			return "Student data Deleted Successfully";
		}
			return "Student not found ";
	}
}













