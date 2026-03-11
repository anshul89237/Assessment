package com.lpu.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.Entity.Course;
import com.lpu.Entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

@Component
public class StudentDAO {
	
	@Autowired
	private EntityManagerFactory emf;
	
	public Student saveStudent(Student s)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
				
		et.begin();
		em.persist(s);
		et.commit();
		em.close();
		
		return s;
	}
	
	public void updateStudentMarks(int id, double newMarks)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Student s = em.find(Student.class, id);
				
		et.begin();
		if(s != null) 
			s.setMarks(newMarks);
		et.commit();
		em.close();
	}
	
	public Student findById(int id)
	{
		EntityManager em = emf.createEntityManager();
		Student s = em.find(Student.class, id);
		
		em.close();
		
		return s;
	}
	
	public void deleteStudentById(int id)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Student s = em.find(Student.class, id);
		
		et.begin();
		if(s != null)
			em.remove(s);
		
		et.commit();
		em.close();
	}
	
	public void giveCourseToStudent(int stuId, int couId)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		Student s = em.find(Student.class, stuId);
		Course c = em.find(Course.class, couId);
		
		
		if(s != null && c != null)
			s.getCourse().add(c);
		
		et.commit();
		em.close();	
	}
}
