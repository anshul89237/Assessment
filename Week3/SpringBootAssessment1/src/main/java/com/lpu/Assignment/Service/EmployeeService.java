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
	
	public Employee updateEmployee(int id, Employee employee)
	{
		Employee emp = repository.findById(id).orElse(null);
		
		emp.setName(employee.getName());
		emp.setPhone(employee.getPhone());
		emp.setEmail(employee.getEmail());
		emp.setSalary(employee.getSalary());
		emp.setDepartment(employee.getDepartment());
		
		return repository.save(emp);
	}
	
	public List<Employee> findInRange(long minSalary, long maxSalary)
	{
		return repository.findInRange(minSalary, maxSalary);
	}
	
	public List<Employee> maxSalary()
	{
		return repository.maxSalary();
	}
	
	public List<Employee> minSalary()
	{
		return repository.minSalary();
	}
	
	public List<Employee> findInDeptAndSal(String department, double salary)
	{
		return repository.findInDepratmentAndSalary(department, salary);
	}
}
