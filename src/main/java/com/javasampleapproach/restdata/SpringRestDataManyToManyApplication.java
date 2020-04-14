package com.javasampleapproach.restdata;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javasampleapproach.restdata.model.Student;
import com.javasampleapproach.restdata.model.Subject;
import com.javasampleapproach.restdata.repository.StudentRepository;

@SpringBootApplication
public class SpringRestDataManyToManyApplication implements CommandLineRunner{
	
	@Autowired
	StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringRestDataManyToManyApplication.class, args);
	}

	@Transactional
	@Override
	public void run(String... arg0) throws Exception {
		
		// delete all tables
		studentRepository.deleteAll();
		
		Student jack = new Student("Jack");
		Student peter = new Student("Peter");
		
		Subject math = new Subject("Mathematics");
		Subject computer = new Subject("Compter");
		
		Set<Subject> subjects = new HashSet<Subject>();
		subjects.add(math);
		subjects.add(computer);
		
		jack.setSubjects(subjects);
		peter.setSubjects(subjects);
		
		studentRepository.save(jack);
		studentRepository.save(peter);
	}
}
