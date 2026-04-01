package com.lpu.SMSAssessment.Service;

import java.util.Collection;
import java.util.Collections;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.lpu.SMSAssessment.Entity.Student;

public class StudentUserDetail implements UserDetails{
	
	private Student student;
		
	public StudentUserDetail(Student student) {
		super();
		this.student = student;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Collections.singleton(new SimpleGrantedAuthority(student.getRole()));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return student.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return student.getEmail();
	}

}
