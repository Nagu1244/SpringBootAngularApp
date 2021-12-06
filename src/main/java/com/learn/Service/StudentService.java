package com.learn.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.Exception.StudentNotFoundException;
import com.learn.model.Student;
import com.learn.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepo;

	public Student create(Student student) {

		return studentRepo.save(student);
	}

	public List<Student> getAllStudents() {
          
		List<Student> listStudents=studentRepo.findAll();
		return listStudents;
	}

	public String updateStudentDetails(int id, Student student) throws StudentNotFoundException {

        Optional<Student> existsStudent=studentRepo.findById(id);
        if(existsStudent.isPresent())
        {
        	Student exists=existsStudent.get();
        	exists.setFirstName(student.getFirstName());
        	exists.setLastName(student.getLastName());
        	exists.setEmail(student.getEmail());
        	exists.setPhoneNumber(student.getPhoneNumber());
        	studentRepo.save(exists);
        }
        else
        {
        	throw new StudentNotFoundException("Student with "+id+" not found");
        }
		return "Student with ID "+id+" updated Successfully";
	}

	public Student getStudentById(int id) {

          Student student=studentRepo.findById(id).get();
		  return student;
	}

	public String deleteStudentById(int id) {

       studentRepo.deleteById(id);
       return "student with ID "+id+" deleted sucessfully";
		
	}

}
