package com.company.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

import com.company.model.Employees;
import com.company.repository.EmployeesRepository;

@Service
public class RelatoryService {

	private EmployeesRepository employeesRepository;

	public RelatoryService(EmployeesRepository employeesRepository) {
		this.employeesRepository = employeesRepository;
	}
	
	public void initial(Scanner scanner) {
		System.out.println("RELATORY");
		System.out.println("What action do you to make:");
		System.out.println("1 - Find By Name");
		int action = scanner.nextInt();
		switch (action) {
		case 1:
			findByName(scanner);
			
			break;

		default:
			break;
		}
	}

	private void findByName(Scanner scanner) {
		System.out.println("What is name");
		List<Employees> employees = employeesRepository.findByName(scanner.next());
		for (Employees employee : employees) {
			System.out.println(employee.getName());
		}
	}
}
