package com.lpu.Controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.lpu.Service.CourseService;
import com.lpu.Service.StudentService;

public class StudentCourseController {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
		
		StudentService stuService = context.getBean(StudentService.class);
		CourseService couService = context.getBean(CourseService.class);
		
		System.out.println("-----Adding Students-----");
		stuService.registerStudent("Ansh", 21, 90.0);
		stuService.registerStudent("Ram", 22, 85.5);
		stuService.registerStudent("Shyam", 20, 65.0);
		
		System.out.println("-----Adding Courses-----");
		couService.registerCourse("Core Java", "Ravi Sir");
		couService.registerCourse("SQL", "Vaishnav Sir");
		
		System.out.println("-----Assigning Courses-----");
		stuService.giveCourseToStudent(1, 1);
		stuService.giveCourseToStudent(1, 2);
		stuService.giveCourseToStudent(2, 1);
		stuService.giveCourseToStudent(3, 1);
		stuService.giveCourseToStudent(3, 2);
		
		System.out.println("-----Fetch Students-----");
		System.out.println(stuService.getStudentById(1));
		System.out.println(stuService.getStudentById(2));
		System.out.println(stuService.getStudentById(3));
//		
//		System.out.println("-----Update Marks-----");
//		stuService.updateMarks(1, 95.0);
//		
//		System.out.println("-----All Course-----");
//		couService.getAllCourse().forEach(System.out::println);
//		
//		System.out.println("-----Update Course-----");
//		couService.updateCourse(1, "Advance Java", "Sandeep Sir");
//		System.out.println(couService.getCourseById(1));
//		
//		System.out.println("-----Delete Student-----");
//		stuService.deleteStudent(3);
//		
//		System.out.println("-----Delete Course-----");
//		couService.deleteCourse(2);
	}
}
