package com.company;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import  com.company.service.FunctionService;;

@SpringBootApplication
public class CourseJpaSpringDataApplication implements CommandLineRunner {

	private final FunctionService functionService;
	private boolean system = true;

	public CourseJpaSpringDataApplication(FunctionService functionService) {
		this.functionService = functionService;
	}

	public static void main(String[] args) {
		SpringApplication.run(CourseJpaSpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		while(system) {
			System.out.println("What action do you want to take?");
			System.out.println("0 - Exit");
			System.out.println("1 - Function");			
			int action = scanner.nextInt();
			
			if (action == 1) {
				functionService.initial(scanner);
			}else {
				this.system = false;
			}
		}
	}

}
