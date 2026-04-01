package com.lpu.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.Entity.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

@Component
public class CourseDAO {
	
	@Autowired
	private EntityManagerFactory emf;
	
	public Course saveCourse(Course c)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(c);
		et.commit();
		
		return c;
	}
	
	public Course findById(int id)
	{
		EntityManager em = emf.createEntityManager();
		Course c = em.find(Course.class, id);
		em.close();
		return c;
	}
	
	public List<Course> findAll()
	{
		EntityManager em = emf.createEntityManager();
        List<Course> list = em.createQuery("from Course", Course.class).getResultList();
        em.close();
        return list;
	}
	
	public void updateCourseById(int id, String name, String trainerName)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Course c = em.find(Course.class, id);
		
		et.begin();
		if(c != null)
		{
			c.setName(name);
			c.setTrainerName(trainerName);
		}
		et.commit();
		em.close();
	}
	
	public void deleteCourseById(int id)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Course c = em.find(Course.class, id);
		
		et.begin();
		if(c != null)
			em.remove(c);
		
		et.commit();
		em.close();
	}
}
