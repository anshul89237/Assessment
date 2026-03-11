package com.lpu.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.DAO.StudentDAO;
import com.lpu.Entity.Student;

@Component
public class StudentService {
	
	@Autowired
	private StudentDAO dao;
	
	public Student registerStudent(String name, int age, double marks)
	{
		if(age < 18 || age > 100)
		{
			throw new IllegalArgumentException("Invalid age");
		}
		
		if(marks < 0 || marks > 100)
		{
			throw new IllegalArgumentException("Invalid marks");
		}
		
		Student s = new Student(name, age, marks);
		return dao.saveStudent(s);
	}
	
	public Student getStudentById(int id)
	{
		Student s = dao.findById(id);
		if(s == null)
		{
			throw new IllegalArgumentException("Student not found");
		}
		
		return s;
	}
	
	public void updateMarks(int id, double newMarks)
	{
		if(newMarks < 0 || newMarks > 100)
		{
			throw new IllegalArgumentException("Invalid marks");
		}
		dao.updateStudentMarks(id, newMarks);
	}
	
	public void deleteStudent(int id)
	{
		dao.deleteStudentById(id);
	}
	
	public void giveCourseToStudent(int stuId, int couId)
	{
		dao.giveCourseToStudent(stuId, couId);
	}
}