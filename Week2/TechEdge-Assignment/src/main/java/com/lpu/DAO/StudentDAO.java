package com.lpu.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.Entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

@Component
public class StudentDAO {

	@Autowired
	private EntityManagerFactory emf;
	
	public Student addStudent(Student s)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(s);
		et.commit();
		em.close();
		
		return s;
	}
	
	public void updateStudent(int id, String email)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Student s = em.find(Student.class, id);
		
		et.begin();
		if(s != null)
			s.setEmail(email);
		et.commit();
		em.close();
	}
	
    public void deleteStudent(int studentId) 
    {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Student student = em.find(Student.class, studentId);

        et.begin();
        if (student != null)
            em.remove(student);
        et.commit();
        
        em.close();
    }

    public Student getStudentById(int studentId) 
    {
        EntityManager em = emf.createEntityManager();
        
        Student student = em.find(Student.class, studentId);
        
        em.close();
        
        return student;
    }
}
