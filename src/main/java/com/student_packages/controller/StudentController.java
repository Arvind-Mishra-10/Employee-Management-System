package com.student_packages.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.student_packages.entity.Student;
import com.student_packages.service.StudentService;
import com.student_packages.util.emailService;
//Servlet Style Style crud Operation
@Controller
public class StudentController {
		
	@Autowired   
	private StudentService studentService;
	@Autowired
	emailService emailservices;
	
	//handler methods
	//http://localhost:8080/viewStudentForm
	
	@RequestMapping("viewStudentForm")
	public String viewStudentForm() {
		return "create_student";
	}

	@RequestMapping("/saveStudent")
	public String saveStudentInformation(@ModelAttribute Student stdo , Model model) {
		System.out.println(stdo.getFirstName());
		System.out.println(stdo.getLastName());
		System.out.println(stdo.getEmail());
		System.out.println(stdo.getMobile());
		studentService.saveStudent(stdo);
		
		emailservices.sendSimpleEmail(stdo.getEmail(), "testing", "phir jara raha h email");
		
		model.addAttribute("msg", "Record Saved!!!!!");
		return "create_student";
	}
	
	@RequestMapping("/list_student")
	public String getAllStudent(ModelMap model) {
		List<Student> stdo = studentService.getStudents();
		model.addAttribute("stds",stdo);
		
		return"list_student";
		
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("id")long id, Model model) {
		studentService.deleteLead(id);
		List<Student> stdo = studentService.getStudents();
		model.addAttribute("stds",stdo);
		return"list_student";
	}
	
	@RequestMapping("/update")
	public String update(@RequestParam("id")long id, Model model) {
		Student byIDentity = studentService.findStudentById(id);
		model.addAttribute("studentStoredData",byIDentity);
		return"updateStudentData";
	}
	
	@RequestMapping("/updateMethod")
	public String Updatemethod(@ModelAttribute Student stdos , Model model) {
			studentService.update(stdos);
			model.addAttribute("msg", "Record Updated!!!!!");
			List<Student> stdo = studentService.getStudents();
			model.addAttribute("stds",stdo);
			
			return "list_student";
		}
		
	}
	
	

