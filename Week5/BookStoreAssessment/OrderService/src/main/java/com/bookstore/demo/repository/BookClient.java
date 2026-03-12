package com.bookstore.demo.repository;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bookstore.demo.model.BookDTO;

@FeignClient(name = "BOOKSERVICE")
public interface BookClient {
	
	@GetMapping("/api/books")
	public List<BookDTO> getAllBooks();
	
	@GetMapping("/api/books/{id}")
	public BookDTO getBookById(@PathVariable long id);
	
	@PostMapping("/api/books")
	public BookDTO createBook(@RequestBody BookDTO dto);
	
	@PutMapping("/api/books/{id}")
	public BookDTO updateBook(@PathVariable long id, @RequestBody BookDTO dto);
	
	@DeleteMapping("/api/books/{id}")
	public void deleteBook(@PathVariable long id);
}
