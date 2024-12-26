package com.student_packages.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student_packages.entity.Student;
import com.student_packages.repository.StudentRepository;
@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository StudentRepo;
	
	@Override
	public void saveStudent(Student stdo) {
		StudentRepo.save(stdo);

	}

	@Override
	public List<Student> getStudents() {
		List<Student> students = StudentRepo.findAll();
		return students;
	}

	@Override
	public void deleteLead(long id) {
		StudentRepo.deleteById(id);
		
	}

	@Override
	public Student findStudentById(long id) {
		Optional<Student> byId = StudentRepo.findById(id);
		if (byId.isPresent()) {
			return byId.get();
		}
		return null;
	}

	@Override
	public void update(Student stdos) {
		StudentRepo.save(stdos);
	}

	
	

	

}
