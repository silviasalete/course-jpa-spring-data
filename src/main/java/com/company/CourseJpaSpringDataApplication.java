package com.company;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import  com.company.service.FunctionService;
import com.company.service.RelatoryDynamicEmployees;
import com.company.service.RelatoryService;
import com.company.service.WorkUnityService;
import  com.company.service.EmployeesService;

@SpringBootApplication
public class CourseJpaSpringDataApplication implements CommandLineRunner {

	private final FunctionService functionService;
	private final EmployeesService employeesService;
	private final WorkUnityService workUnityService;
	private final RelatoryService relatoryService;
	private final RelatoryDynamicEmployees relatoryDynamicEmployees;
	private boolean system = true;

	public CourseJpaSpringDataApplication(RelatoryDynamicEmployees relatoryDynamicEmployees,RelatoryService relatoryService, FunctionService functionService,EmployeesService employeesService, WorkUnityService workUnityService) {
		this.functionService = functionService;
		this.employeesService = employeesService;
		this.workUnityService =  workUnityService;
		this.relatoryService =relatoryService;
		this.relatoryDynamicEmployees =relatoryDynamicEmployees;
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
			System.out.println("3 - WorkUnity");				
			System.out.println("4 - Relatory");				
			System.out.println("5 - RelatoryDynamicEmployees");				
			int action = scanner.nextInt();
			
			if (action == 1) {
				functionService.initial(scanner);
			}else if (action == 2) {
				employeesService.initial(scanner);
			}else if (action == 3) {
				workUnityService.initial(scanner);
			}else if (action == 4) {
				relatoryService.initial(scanner);
			}else if (action == 5) {
				relatoryDynamicEmployees.initial(scanner);
			}else {
				this.system = false;
			}
		}
	}

}
