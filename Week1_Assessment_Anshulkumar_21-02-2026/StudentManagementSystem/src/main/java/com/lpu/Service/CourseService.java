package com.lpu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.DAO.CourseDAO;
import com.lpu.Entity.Course;

@Component
public class CourseService {
	
	@Autowired
	private CourseDAO service;
	
	public Course registerCourse(String name, String trainerName)
	{
		Course c = new Course(name, trainerName);
		return service.saveCourse(c);
	}
	
	public Course getCourseById(int id)
	{
		return service.findById(id);
	}
	
	public List<Course> getAllCourse()
	{
		return service.findAll();
	}
	
	public void updateCourse(int id, String name, String trainerName)
	{
		service.updateCourseById(id, name, trainerName);
	}
	
	public void deleteCourse(int id)
	{
		service.deleteCourseById(id);
	}
}
