package com.company;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import  com.company.service.FunctionService;
import  com.company.service.EmployeesService;

@SpringBootApplication
public class CourseJpaSpringDataApplication implements CommandLineRunner {

	private final FunctionService functionService;
	private final EmployeesService employeesService;
	private boolean system = true;

	public CourseJpaSpringDataApplication(FunctionService functionService,EmployeesService employeesService) {
		this.functionService = functionService;
		this.employeesService = employeesService;
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
			System.out.println("2 - Employees");				
			int action = scanner.nextInt();
			
			if (action == 1) {
				functionService.initial(scanner);
			}else if (action == 2) {
				employeesService.initial(scanner);
			}else {
				this.system = false;
			}
		}
	}

}
