package com.example.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Student;
import com.example.demo.ServiceLayers.StudentRepository;

@Controller
public class StudentController {
	
	private final StudentRepository studentRepo;

	public StudentController(StudentRepository studnetRepo) {
		this.studentRepo = studnetRepo;
	}
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showForm(Model model) {
		model.addAttribute("student", new Student());
		return "register";
	}
	
	@PostMapping("/register")
	public String adding(@ModelAttribute Student student,RedirectAttributes redirectAttributes) {
		if(student.getStudentId()==0) {
			redirectAttributes.addFlashAttribute("msg","Student Added Succesfully!");
		}else {
			redirectAttributes.addFlashAttribute("msg","Student Updated Successfully!");
		}
		studentRepo.save(student);
		return "redirect:/students";  
		
	}
	/*User submits form (POST /register)
	Students page opens
	User presses Refresh (F5)
💥 POST request is sent again
💥 Student is inserted again
💥 Duplicate records*/
	
	@GetMapping("/students")
	public String viewStudent(Model model) {
		model.addAttribute("students", studentRepo.findAll());
		return "students";
		
	}
	
	@GetMapping("/edit/{id}")
	public String editStudent(@PathVariable Integer id,Model model) {
		Student student=studentRepo.findById(id).orElse(null);
		model.addAttribute("student", student);
		return "register";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable Integer id) {
		studentRepo.deleteById(id);
		return "redirect:/students";
	}

}
