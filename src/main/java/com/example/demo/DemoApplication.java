package com.example.demo;

import com.example.demo.Repository.StudentsRepository;
import com.example.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
//@EnableJpaRepositories(basePackages = "com.example.demo.Repository")
@EntityScan(basePackages = {"com.example.demo.entity"})
public class DemoApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Autowired
	private StudentsRepository studentsRepository;
	@Override
	public void run(String... args) throws Exception {

	}
}
