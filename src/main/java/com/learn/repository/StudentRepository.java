package com.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
