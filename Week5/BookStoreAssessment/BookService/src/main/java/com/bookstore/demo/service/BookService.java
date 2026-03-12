package com.bookstore.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookstore.demo.model.Book;
import com.bookstore.demo.repository.BookRepository;

@Service
public class BookService {

    private BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> findAll() {
        return repository.findAll();
    }
    
    public Book findById(long id)
    {
    	return repository.findById(id).orElse(null);
    }
    
    public Book saveBook(Book book)
    {
    	return repository.save(book);
    }
    
    public Book updateBook(long id, Book book)
    {
    	Book b = repository.findById(id).orElse(null);
    	
    	if(b == null)
    		return null;
    		
    	b.setTitle(book.getTitle());	
    	b.setAuthor(book.getAuthor());
    	b.setPrice(book.getPrice());
    	b.setQuantity(book.getQuantity());
    	b.setCategory(book.getCategory());
    	
    	return repository.save(b);
    }
    
    public void deleteById(long id)
    {
    	repository.deleteById(id);
    }
}