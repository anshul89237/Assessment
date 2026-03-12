package com.bookstore.demo.controller;

import java.util.List;

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

import com.bookstore.demo.model.Book;
import com.bookstore.demo.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {
	
	private BookService service;
	
	public BookController(BookService service) {
		super();
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<Book>> findAll()
	{
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> findById(@PathVariable long id)
	{
		return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Book> saveBook(@RequestBody Book book)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(service.saveBook(book));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable("id") long id, @RequestBody Book book)
	{
		return ResponseEntity.status(HttpStatus.OK).body(service.updateBook(id, book));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable long id)
	{
		service.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
}
