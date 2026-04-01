package com.lpu.SMSAssessment.Entity;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;

@Entity
public class Student implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String password;
	private String course;
	private double marks;
	private String role;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "profile_image")
	private FileData profileImage;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "assignment_upload")
	private FileData assignmentUpload;
	
	public Student()
	{
		
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public FileData getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(FileData profileImage) {
		this.profileImage = profileImage;
	}

	public FileData getAssignmentUpload() {
		return assignmentUpload;
	}

	public void setAssignmentUpload(FileData assignmentUpload) {
		this.assignmentUpload = assignmentUpload;
	}
}
