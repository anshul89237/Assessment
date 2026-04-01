package com.lpu.SMSAssessment.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.SMSAssessment.Entity.Student;
import com.lpu.SMSAssessment.Service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@PostMapping("/create")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(service.saveStudent(student));
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Student> findById(@PathVariable int id)
	{
		return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Student>> findAll()
	{
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student)
	{
		return ResponseEntity.status(HttpStatus.OK).body(service.updateStudentDetails(id, student));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable int id)
	{
		service.deleteStudent(id);
		return ResponseEntity.status(HttpStatus.OK).body("Student Deleted Successfully");
	}
	
	@GetMapping("/paging/{page}/{size}")
	public ResponseEntity<List<Student>> studentPaging(@PathVariable int page, @PathVariable int size)
	{
		return ResponseEntity.status(HttpStatus.OK).body(service.studentPagination(page, size));
	}
	
	@GetMapping("/sort/{page}/{size}/{field}")
	public ResponseEntity<List<Student>> sortByMarks(@PathVariable int page, @PathVariable int size, @PathVariable String field)
	{
		return ResponseEntity.status(HttpStatus.OK).body(service.sortStudentByMarks(page, size, field));
	}
}
