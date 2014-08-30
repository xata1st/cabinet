package com.xata.test.repository;

import org.springframework.data.repository.CrudRepository;

import com.xata.test.domain.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>{

}
