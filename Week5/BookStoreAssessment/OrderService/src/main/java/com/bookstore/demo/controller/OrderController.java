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

import com.bookstore.demo.model.Order;
import com.bookstore.demo.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	
	private OrderService service;

	public OrderController(OrderService service) {
		super();
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll()
	{
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> findById(@PathVariable long id)
	{
		return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Order> saveOrder(@RequestBody Order order)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(service.placeOrder(order));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Order> updateOrder(@PathVariable long id, @RequestBody String status)
	{
		return ResponseEntity.status(HttpStatus.OK).body(service.updateStatus(id, status));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable long id)
	{
		return ResponseEntity.noContent().build();
	}
}
