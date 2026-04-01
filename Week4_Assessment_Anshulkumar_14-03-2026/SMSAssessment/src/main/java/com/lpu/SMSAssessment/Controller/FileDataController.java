package com.lpu.SMSAssessment.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lpu.SMSAssessment.Entity.FileData;
import com.lpu.SMSAssessment.Repository.FileDataRepository;
import com.lpu.SMSAssessment.Service.StudentService;

@RestController
@RequestMapping("/file")
public class FileDataController {
	
	@Autowired
	private StudentService service;
	@Autowired
	private FileDataRepository repository;
	
	@PostMapping("{id}/image")
	public ResponseEntity<String> uploadImage(@PathVariable int id, @RequestParam MultipartFile file) throws IOException
	{
		return ResponseEntity.ok(service.uploadStudentImage(id, file));
	}
	
	@PostMapping("{id}/assignment")
	public ResponseEntity<String> uploadAssignment(@PathVariable int id, @RequestParam MultipartFile file) throws IOException
	{
		return ResponseEntity.ok(service.uploadAssignment(id, file));
	}
	
	@GetMapping("/download/{id}")
	public ResponseEntity<byte[]> download(@PathVariable Long id)
	{
		FileData file = repository.findById(id).orElseThrow(() -> new RuntimeException("File not found with id: " + id));
		
		return ResponseEntity.ok().header(org.springframework.http.HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + file.getFileName())
				.header(org.springframework.http.HttpHeaders.CONTENT_TYPE, file.getFieldType()) 
				.body(file.getData());
	}
}
