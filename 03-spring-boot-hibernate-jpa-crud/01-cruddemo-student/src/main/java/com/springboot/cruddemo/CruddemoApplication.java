package com.springboot.cruddemo;

import com.springboot.cruddemo.dao.StudentDAO;
import com.springboot.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			deleteAllStudents(studentDAO);
		};
	}

	private void createMultipleStudents(StudentDAO studentDAO){
		System.out.println("Creating 3 student objects...");
		Student theStudent1 = new Student("Darko", "Darkic", "Darko@gmail.com");
		Student theStudent2 = new Student("Marko", "Markic", "Marko@gmail.com");
		Student theStudent3 = new Student("Maricius", "Markicae", "Maricius@gmail.com");

		System.out.println("Saving the student objects...");
		studentDAO.save(theStudent1);
		studentDAO.save(theStudent2);
		studentDAO.save(theStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating the student object...");
		Student theStudent = new Student("Erik", "Birt", "erikbj3@gmail.com");

		System.out.println("Saving the student object...");
		studentDAO.save(theStudent);

		System.out.println("Saved student's ID: " + theStudent.getId());
	}

	private	void readStudent(StudentDAO studentDAO){
		System.out.println("Creating a new student...");
		Student tempStudent = new Student("Rea", "Ban", "Rea.ban@gmail.com");

		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		System.out.println("Saved tempStudent generated id: " + tempStudent.getId());
		Student myStudent = studentDAO.findById(tempStudent.getId());

		System.out.println("Found the student: " + myStudent);
	}
	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> studentList = studentDAO.findAll();
		for (Student tempStudent : studentList) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudentLastName(StudentDAO studentDAO, String lastName) {
		List<Student> studentList = studentDAO.findByLastName(lastName);
		for (Student tempStudent : studentList) {
			System.out.println(tempStudent);
		}
	}

	private void updateStudent(StudentDAO studentDAO, int id, String firstName){
		System.out.println("Getting student with ID: " + id);
		Student myStudent = studentDAO.findById(id);

		System.out.println("Updating student");
		myStudent.setFirstName(firstName);
		studentDAO.update(myStudent);
		System.out.println("Updated student: " + myStudent);
	}

	private void deleteStudent(StudentDAO studentDAO, int id){
		System.out.println("Deleting student with ID: " + id);
		studentDAO.delete(id);
	}

	private void deleteAllStudents(StudentDAO studentDAO){
		System.out.println("Deleting all students\n");
		int numRows = studentDAO.deleteAll();
		System.out.println("Delete row count: " + numRows);
	}

}






