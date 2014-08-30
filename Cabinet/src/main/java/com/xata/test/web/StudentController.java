package com.xata.test.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xata.test.domain.Student;
import com.xata.test.repository.StudentRepository;

@Controller
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@RequestMapping(value="/getStudent", method = RequestMethod.GET)
	public String getStudent() {
		
//		Student student1 = new Student("Sergey", "Vlasko", "Krakow", "8282898");
//		studentRepository.save(student1);
		
		for(Integer i = 0; i < 10; i++) {
			System.out.println(i);
		}
		
		Iterable<Student> myIter = studentRepository.findAll();
		System.out.println(myIter.toString());
		return "asd";
	}
}