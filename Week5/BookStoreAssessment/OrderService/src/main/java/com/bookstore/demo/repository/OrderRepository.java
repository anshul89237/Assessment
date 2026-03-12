package com.bookstore.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.demo.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
