package com.cozentus.SpringSecurityDBApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.cozentus.SpringSecurityDBApp.Entity.Student;
import com.cozentus.SpringSecurityDBApp.Repository.StudentRepository;


@Component
public class CustomStudentDetailsService implements UserDetailsService {
	
	
	@Autowired
	private StudentRepository studrep;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Student std = studrep.findByEmail(email);

		if (std == null) {
			throw new UsernameNotFoundException("student name not found");
		} else {
			return new CustomStudent(std);
		}
	}

}
