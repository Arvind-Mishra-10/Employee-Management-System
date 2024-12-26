package com.student_packages.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student_packages.entity.Student;

public interface StudentRepository extends JpaRepository<Student , Long>{


}
