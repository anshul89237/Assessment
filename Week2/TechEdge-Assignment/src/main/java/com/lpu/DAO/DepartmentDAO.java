package com.lpu.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.Entity.Department;
import com.lpu.Entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

@Component
public class DepartmentDAO {
	
	@Autowired
	private EntityManagerFactory emf;
	
	public Department addDepartment(Department d)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(d);
		et.commit();
		em.close();
		
		return d;
	}
	
	public void assignStudentToDepartment(int id, Student student)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Department dept = em.find(Department.class, id);
		
		et.begin();
		if(dept != null)
		{
	        Student s = em.merge(student);
	        s.setDepartment(dept);
	        
	        List<Student> list = dept.getStudents();
	        
	        if (list == null) 
	        {
	            list = new ArrayList<>();
	            dept.setStudents(list);
	        }
	        if (!list.contains(s))
	            list.add(s);
	        em.merge(dept);
		}
		et.commit();
		em.close();
	}
	
	public Department getDepartmentById(int id)
	{
		EntityManager em = emf.createEntityManager();
		
		Department dept = em.find(Department.class, id);
		if(dept != null)
		{
			dept.getStudents().size();
		}
		em.close();
		
		return dept;
	}
	
	public List<Student> viewStudentByDepartment(int id)
	{
		EntityManager em = emf.createEntityManager();
		
		Department dept = em.find(Department.class, id);
		List<Student> list = null;
		
		if(dept != null)
		{
			list = dept.getStudents();
			list.size();
		}
		em.close();
		
		return list;
	}
	
	public void updateDepartment(int id, String deptName)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Department dept = em.find(Department.class, id);
		
		et.begin();
		if(dept != null)
			dept.setName(deptName);
		et.commit();
		em.close();
	}
	
	public void deleteDepartmentById(int id)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Department dept = em.find(Department.class, id);
		
		et.begin();
		if(dept != null)
			em.remove(dept);
		et.commit();
		em.close();
	}
}
