package com.lpu.Assignment.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lpu.Assignment.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	List<Employee> findByName(String name);
	
	List<Employee> findByDepartment(String department);
	
	List<Employee> findByPhone(long phone);
	
	List<Employee> findByEmail(String email);
	
	@Query("select e from Employee e where e.salary between ?1 and ?2")
	List<Employee> findInRange(long minSalary, long maxSalary);

	@Query("select e from Employee e where e.salary = (select max(e.salary) from Employee e)")
	List<Employee> maxSalary();
	
	@Query("select e from Employee e where e.salary = (select min(e.salary) from Employee e)")
	List<Employee> minSalary();
	
	@Query("select e from Employee e where e.department = ?1 and e.salary > ?2")
	List<Employee> findInDepratmentAndSalary(String department, double salary);
	
}
