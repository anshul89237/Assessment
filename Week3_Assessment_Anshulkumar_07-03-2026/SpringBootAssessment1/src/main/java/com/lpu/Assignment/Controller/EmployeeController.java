package com.lpu.Assignment.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.Assignment.Entity.Employee;
import com.lpu.Assignment.Service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/employees")
	public Employee saveEmployee(@RequestBody Employee employee)
	{
		return service.saveEmployee(employee);
	}
	
	@GetMapping("/employees")
	public List<Employee> findAllEmployee()
	{
		return service.findAllEmployee();
	}
	
	@GetMapping("/employees/search")
	public Employee findEmployeeById(@RequestParam int id)
	{
		return service.findById(id);
	}
	
	@DeleteMapping("/employees/delete")
	public String deleteById(@RequestParam int id)
	{
		service.deleteById(id);
		return "Employee Deleted";
	}
	
	@GetMapping("/employees/searchName")
	public List<Employee> findByName(@RequestParam String name)
	{
		return service.findByName(name);
	}
	
	@GetMapping("/employees/searchDepartment")
	public List<Employee> findByDepartment(@RequestParam String department)
	{
		return service.findByDepartment(department);
	}
	
	@GetMapping("/employees/searchPhone")
	public List<Employee> findByPhone(@RequestParam long phone)
	{
		return service.findByPhone(phone);
	}
	
	@GetMapping("/employees/searchEmail")
	public List<Employee> findByEmail(@RequestParam String email)
	{
		return service.findByEmail(email);
	}
	
	@PutMapping("/employees/update")
	public Employee updateEmployee(@RequestParam int id, @RequestBody Employee employee)
	{
		service.updateEmployee(id, employee);
		return employee;
	}
	
	@GetMapping("/employees/findInRange")
	public List<Employee> findInRange(@RequestParam long minSalary, @RequestParam long maxSalary)
	{
		return service.findInRange(minSalary, maxSalary);
	}
	
	@GetMapping("/employees/maxSalary")
	public List<Employee> maxSalary()
	{
		return service.maxSalary();
	}
	
	@GetMapping("/employees/minSalary")
	public List<Employee> minSalary()
	{
		return service.minSalary();
	}
	
	@GetMapping("/employees/deptSal")
	public List<Employee> deptSalRange(@RequestParam String department, @RequestParam double salary)
	{
		return service.findInDeptAndSal(department, salary);
	}
}
