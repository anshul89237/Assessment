package com.bookstore.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bookstore.demo.model.BookDTO;
import com.bookstore.demo.model.Order;
import com.bookstore.demo.repository.BookClient;
import com.bookstore.demo.repository.OrderRepository;

@Service
public class OrderService {

	private OrderRepository repository;
	private BookClient client;
	
	public OrderService(OrderRepository repository, BookClient client) {
		super();
		this.repository = repository;
		this.client = client;
	}

	public List<Order> findAll()
	{
		return repository.findAll();
	}
	
	public Order findById(long id)
	{
		return repository.findById(id).orElse(null);
	}
	
	public Order placeOrder(Order order)
	{
		BookDTO dto = client.getBookById(order.getBookId());
		
		double total = dto.getPrice() * order.getQuantity();
		
		order.setTotalPrice(total);
		order.setStatus("PLACED");
		order.setOrderDate(LocalDate.now());
		
		return repository.save(order);
	}
	
	public Order updateStatus(long id, String status)
	{
		Order o = repository.findById(id).orElse(null);
		
		if(o == null)
			return null;
		
		o.setStatus(status);
		
		return repository.save(o);
	}
	
	public void deleteById(long id)
	{
		repository.deleteById(id);
	}
}
