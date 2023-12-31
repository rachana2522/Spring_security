package com.cozentus.SpringSecurityDBApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cozentus.SpringSecurityDBApp.Entity.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	public Student findByEmail(String email);
	
}
