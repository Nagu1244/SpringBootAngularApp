package com.learn.controller;

import java.util.List;

import org.hibernate.annotations.OptimisticLocking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.Service.StudentService;
import com.learn.model.Student;



@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = {"*"})

public class StudentController {
	
	@Autowired
	private StudentService studentService;

	@PostMapping(path = "/add", consumes = "application/json")
	public ResponseEntity<String> createStudent(@RequestBody Student student) {
		Student fromStudent = studentService.create(student);
		String message = "Student with Id: " + fromStudent.getId() + " is created Successfully";
		return ResponseEntity.status(HttpStatus.OK).body(message);
	}
	
	@GetMapping(path="/allStudents")
	public ResponseEntity<List<Student>> getAllStudent()
	{
		List<Student> listStudents=studentService.getAllStudents();
		return ResponseEntity.status(HttpStatus.OK).body(listStudents);
	}
	
	@PutMapping(path = "/update/{id}",consumes = "application/json")
	public ResponseEntity<String> updateStudentInfo(@PathVariable(name="id") int id,@RequestBody Student student)
	{
		String message=studentService.updateStudentDetails(id,student);
		return ResponseEntity.ok(message);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable(name = "id") int id)
	{
		Student studentById=studentService.getStudentById(id);
		return ResponseEntity.status(HttpStatus.OK).body(studentById);
	}
	
	@DeleteMapping(path="/delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable(name="id") int id)
	{
		String deleteMessage=studentService.deleteStudentById(id);
		return ResponseEntity.status(HttpStatus.OK).body(deleteMessage);
	}
}
