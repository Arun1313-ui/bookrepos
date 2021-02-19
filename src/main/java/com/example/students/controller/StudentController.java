package com.example.students.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.example.students.exception.ResourceNotFoundException;
import com.example.students.model.Student;
import com.example.students.repository.StudentRepository;


@RestController
@RequestMapping("/api")
public class StudentController{
	
	@Autowired
	StudentRepository studentRepository;
	
	@GetMapping("/students")
	public List<Student>getAllStudents()
	{
		return studentRepository.findAll();
	}
	
	 @PostMapping("/students")
	public Student createStudent(@Valid @RequestBody Student student) {
		return studentRepository.save(student);
	}
	
	 @GetMapping("/students/{id}")
	public Student getStudentById(@PathVariable(value="id")Long studentId) {
		return studentRepository.findById(studentId)
				.orElseThrow(() ->new ResourceNotFoundException("Student","id",studentId));
			
	}
	 

	@PutMapping("/students/{id}")
	public Student updateStudent(@PathVariable(value="id")Long studentId,@Valid @RequestBody Student studentDetails)
	{
		Student student=studentRepository.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student","id",studentId));
		student.setName(studentDetails.getName());
		student.setCity(studentDetails.getCity());
		 Student updatedStudent = studentRepository.save(student);
	        return updatedStudent;
		
	}
	 
	 @DeleteMapping("/students/{id}")
	 public ResponseEntity<?> deleteStudent(@PathVariable(value = "id") Long studentId) {
	        Student student = studentRepository.findById(studentId)
	                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", studentId));

	        studentRepository.delete(student);

	        return ResponseEntity.ok().build();
	    }
	}



