package com.student_packages.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student_packages.entity.Student;
import com.student_packages.repository.StudentRepository;
//For Postman Style crud Operation
@RestController
@RequestMapping("/api/student")
public class StudentRestController {
		
	@Autowired
	private StudentRepository studentRepo;
	
	@GetMapping
	public  ResponseEntity<List<Student>>getStudents(){
		List<Student> students = studentRepo.findAll();
		return new ResponseEntity<>(students,HttpStatus.CREATED);
	}
	
	@PostMapping
	public ResponseEntity<Student> saveStudent(@RequestBody Student stdo) {
		Student studentSave = studentRepo.save(stdo);
	return new ResponseEntity<>(studentSave,HttpStatus.CREATED); 
	}
	
	
	
	
	
	//http://localhost:8080/api/student?id=24
	@PutMapping
	public ResponseEntity<Student> updateStudent(
			@RequestParam("id")long id,
			@RequestBody Student stdo) {
		Optional<Student> byIDentity = studentRepo.findById(id);
	
		Student student = byIDentity.get();
		student.setFirstName(stdo.getFirstName());
		student.setLastName(stdo.getLastName());
		student.setEmail(stdo.getEmail());
		student.setMobile(stdo.getMobile());
		Student saveStudent = studentRepo.save(student);
		return new ResponseEntity<>(saveStudent,HttpStatus.OK);
		
	}
	
	//http://localhost:8080/api/student/1
		@DeleteMapping("/{id}")
		public ResponseEntity<String> delteStudent(@PathVariable("id")long id) {
			  if (!studentRepo.existsById(id)) { // Check if the record exists
			        throw new RuntimeException("Student with ID " + id + " not found");
			    }
			studentRepo.deleteById(id);
			return new ResponseEntity<>("Record is Deleted",HttpStatus.OK);
		}
		
		//http://localhost:8080/api/student/1
//		@DeleteMapping("/{id}")
//		public ResponseEntity<String> delteStudent(@PathVariable("id")long id) {
//			studentRepo.deleteById(id);
//			return new ResponseEntity<>("Record is Deleted",HttpStatus.OK);
//		}
		
		@GetMapping("/{id}")
		public ResponseEntity<Student> getStudentByid(@PathVariable("id")long id) {
			Student student = studentRepo.findById(id).get();
			return new ResponseEntity<>(student,HttpStatus.OK);
		}
		
		
}
