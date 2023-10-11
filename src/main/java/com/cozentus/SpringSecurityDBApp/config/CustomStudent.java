package com.cozentus.SpringSecurityDBApp.config;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cozentus.SpringSecurityDBApp.Entity.Student;

public class CustomStudent implements UserDetails {
	
	private Student std;
	

	public CustomStudent(Student std) {
		super();
		this.std = std;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(std.getRole());

		return Arrays.asList(authority);
	}

	@Override
	public String getPassword() {
		return std.getPassword();
				
	}

	@Override
	public String getUsername() {
		
		return std.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

}
