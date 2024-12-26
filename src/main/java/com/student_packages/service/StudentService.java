package com.student_packages.service;


import java.util.List;

import com.student_packages.entity.Student;

public interface StudentService {
	
	public void saveStudent(Student stdo);

	public List<Student> getStudents();

	public void deleteLead(long id);

	public Student findStudentById(long id);

	public void update(Student stdos);

}
