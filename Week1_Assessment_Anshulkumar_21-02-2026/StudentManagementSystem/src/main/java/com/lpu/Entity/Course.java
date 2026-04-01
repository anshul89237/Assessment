package com.lpu.Entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Component
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String trainerName;

	public Course() {

	}

	public Course(String name, String trainerName) {
		super();
		this.name = name;
		this.trainerName = trainerName;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", trainer=" + trainerName + "]";
	}
}
