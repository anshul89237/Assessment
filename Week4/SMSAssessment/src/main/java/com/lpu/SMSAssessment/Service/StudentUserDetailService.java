package com.lpu.SMSAssessment.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lpu.SMSAssessment.Entity.Student;
import com.lpu.SMSAssessment.Exception.ResourceNotFoundException;
import com.lpu.SMSAssessment.Repository.StudentRepository;

@Service
public class StudentUserDetailService implements UserDetailsService{
	
	@Autowired
	private StudentRepository repository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Student student = repository.findByEmail(email);
		
		if(student == null)
		{
			throw new ResourceNotFoundException("Student not found"); 
		}
		
		return new StudentUserDetail(student);
	}
}
