package com.lpu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.DAO.DepartmentDAO;
import com.lpu.Entity.Department;
import com.lpu.Entity.Student;

@Component
public class DepartmentService {
		
	@Autowired
	private DepartmentDAO dao;
	
	public Department addDepartment(Department dept)
	{
		return dao.addDepartment(dept);
	}
	
	public void assignStudentToDepartment(int id, Student student)
	{
		dao.assignStudentToDepartment(id, student);
	}
	
	public Department getDepartmentByDId(int id)
	{
		return dao.getDepartmentById(id);
	}
	
	public List<Student> viewStudentByDepartment(int id)
	{
		return dao.viewStudentByDepartment(id);
	}
	
	public void updateDepartment(int id, String name)
	{
		dao.updateDepartment(id, name);
	}
	
	public void deleteDepartment(int id)
	{
		dao.deleteDepartmentById(id);
	}
}
