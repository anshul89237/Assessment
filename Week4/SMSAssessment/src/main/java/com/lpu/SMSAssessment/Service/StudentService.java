package com.lpu.SMSAssessment.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lpu.SMSAssessment.Entity.FileData;
import com.lpu.SMSAssessment.Entity.Student;
import com.lpu.SMSAssessment.Exception.ResourceNotFoundException;
import com.lpu.SMSAssessment.Repository.StudentRepository;

@Service
public class StudentService {

	private StudentRepository repository;
	private PasswordEncoder encoder;
	
	public StudentService(StudentRepository repository, PasswordEncoder encoder) {
		super();
		this.repository = repository;
		this.encoder = encoder;
	}
	
	public Student saveStudent(Student student)
	{
		String pass = encoder.encode(student.getPassword());
		student.setPassword(pass);
		return repository.save(student);
	}
	
	public String uploadStudentImage(int id, MultipartFile file) throws IOException
	{
		Student student = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student with id " + id + " not found"));
		
		FileData image = new FileData();
		image.setFileName(file.getOriginalFilename());
		image.setFieldType(file.getContentType());
		image.setData(file.getBytes());
			
		student.setProfileImage(image);
		repository.save(student);
		
		return "Image Uploaded Successfully with id " + id;
	}
	
	public String uploadAssignment(int id, MultipartFile file) throws IOException
	{
	Student student = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student with id " + id + " not found"));
		
		FileData image = new FileData();
		image.setFileName(file.getOriginalFilename());
		image.setFieldType(file.getContentType());
		image.setData(file.getBytes());
			
		student.setAssignmentUpload(image);
		repository.save(student);
		
		return "Image Uploaded Successfully with id " + id;
	}
	
	
	@Cacheable(value = "students", key = "#id")
	@PostAuthorize("returnObject.email == authentication.name")
	public Student findById(int id)
	{
		return repository.findById(id).get();
	}
	
	@Cacheable(value = "studentList")
	@PreAuthorize("hasRole('ADMIN')")
	public List<Student> findAll()
	{
		return repository.findAll();
	}
	
	
	@CachePut(value = "students", key = "#result.id")
	public Student updateStudentDetails(int id, Student student)
	{
		Student s = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + id));
		
		s.setName(student.getName());
		s.setCourse(student.getCourse());
		s.setMarks(student.getMarks());
		
		return repository.save(s);
	}
	
	@CacheEvict(value = "students", key = "#id", beforeInvocation = true)
	public void deleteStudent(int id)
	{
		Student student = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + id));
		repository.delete(student);
	}
	
	public List<Student> studentPagination(int pageNumber, int size)
	{
		Pageable pageable = PageRequest.of(pageNumber, size);
		
		return repository.findAll(pageable).getContent();
	}
	
	public List<Student> sortStudentByMarks(int pageNumber, int size, String field)
	{
		Pageable pageable = PageRequest.of(pageNumber, size, Sort.by(field).descending());
		
		return repository.findAll(pageable).getContent();
	}
	
	
}
