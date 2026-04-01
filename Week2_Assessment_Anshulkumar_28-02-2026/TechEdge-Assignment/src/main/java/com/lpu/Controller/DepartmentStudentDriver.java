package com.lpu.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lpu.Entity.Department;
import com.lpu.Entity.Student;
import com.lpu.Service.DepartmentService;
import com.lpu.Service.StudentService;

public class DepartmentStudentDriver {
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
		
		DepartmentService dept = context.getBean(DepartmentService.class, "departmentService");
		StudentService student = context.getBean(StudentService.class, "studentService");
		
		Department d1 = new Department();
		d1.setName("CSE");
		dept.addDepartment(d1);
		
		Department d2 = new Department();
		d2.setName("ECE");
		dept.addDepartment(d2);
	
		Student s1 = new Student();
		s1.setName("Anshul");
		s1.setEmail("ansh123@gmail.com");
		student.addStudent(s1);

		Student s2 = new Student();
		s2.setName("Raju");
		s2.setEmail("raju123@gmail.com");
		student.addStudent(s2);
		
		// assign student to department
		dept.assignStudentToDepartment(d1.getId(), s1);
		dept.assignStudentToDepartment(d2.getId(), s2);
		
		
//		 view student by department
		List<Student> list = dept.viewStudentByDepartment(d1.getId());
		System.out.println("CSE DEPARTMENT STUDENT");
		if(list != null)
			list.forEach(System.out::println);
		
		
		// update student email by id
		student.updateStudent(s2.getId(), "raju321@gmail.com");
		System.out.println("Updated Email : " + student.getStudentById(s2.getId()));
		
		
		// get department by id
		Department d = dept.getDepartmentByDId(d1.getId());
		System.out.print(d.getId() + " ");
		System.out.print(d.getName() + " ");
		System.out.print(d.getStudents() + " ");
		System.out.println();
		
		// delete student
//		student.deleteStudent(102);
//		student.deleteStudent(101);
//		System.out.println("Student deleted");
//		
//		// delete department
//		dept.deleteDepartment(11);
//		dept.deleteDepartment(10);
//		System.out.println("Department deleted");
	}
}
