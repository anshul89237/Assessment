package com.lpu.Assignment.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lpu.Assignment.Entity.Employee;
import com.lpu.Assignment.Repository.EmployeeRepository;


@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;
	
	public Employee saveEmployee(Employee employee)
	{
		return repository.save(employee);
	}
	
	public List<Employee> findAllEmployee()
	{
		return repository.findAll();
	}
	
	public Employee findById(int id)
	{
		return repository.findById(id).orElse(null);
	}
	
	public void deleteById(int id)
	{
		repository.deleteById(id);
	}
	
	public List<Employee> findByName(String name)
	{
		return repository.findByName(name);
	}
	
	public List<Employee> findByDepartment(String department)
	{
		return repository.findByDepartment(department);
	}
	
	public List<Employee> findByPhone(long phone)
	{
		return repository.findByPhone(phone);
	}
	
	public List<Employee> findByEmail(String email)
	{
		return repository.findByEmail(email);
	}
}
