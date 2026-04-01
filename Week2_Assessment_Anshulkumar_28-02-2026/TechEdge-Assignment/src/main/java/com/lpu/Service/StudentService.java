package com.lpu.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.DAO.StudentDAO;
import com.lpu.Entity.Student;

@Component
public class StudentService {
	
	@Autowired
	private StudentDAO dao;
	
	public Student addStudent(Student student)
	{
		return dao.addStudent(student);
	}
	
	public void updateStudent(int id, String email)
	{
		dao.updateStudent(id, email);
	}
	
	public void deleteStudent(int id)
	{
		dao.deleteStudent(id);
	}
	
	public Student getStudentById(int id)
	{
		return dao.getStudentById(id);
	}
}
