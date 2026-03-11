package com.lpu.Entity;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Cacheable
public class Student {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	 private String name;
	 private String email;
	 
	 @JoinColumn(name="department_student")
	 @ManyToOne(fetch=FetchType.LAZY)
	 private Department department;
	 
	 public Student() {
	
	}

	 public Student(int id, String name, String email, Department department) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.department = department;
	}

	 public int getId() {
		 return id;
	 }

	 public void setId(int id) {
		 this.id = id;
	 }

	 public String getName() {
		 return name;
	 }

	 public void setName(String name) {
		 this.name = name;
	 }

	 public String getEmail() {
		 return email;
	 }

	 public void setEmail(String email) {
		 this.email = email;
	 }

	 public Department getDepartment() {
		 return department;
	 }

	 public void setDepartment(Department department) {
		 this.department = department;
	 }

	 @Override
	 public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + "]";
	 }
	 
	 
	 
}