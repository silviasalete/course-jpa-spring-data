package com.company.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

import com.company.model.Employees;
import com.company.model.EmployessProjection;
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
		System.out.println("2 - Find Salary by Name");
		System.out.println("3 - Find CPF by Name");
		System.out.println("4 - Find CPF and Name by Id");
		int action = scanner.nextInt();
		switch (action) {
		case 1:
			findByName(scanner);
			
			break;
		case 2:
			findSalaryByNameJPQL(scanner);
			
			break;
		case 3:
			findCPFByNameNativeQuery(scanner);
			
			break;
		case 4:
			findCPFandNameByProjection(scanner);
			
			break;

		default:
			break;
		}
	}

	private void findCPFByNameNativeQuery(Scanner scanner) {
		System.out.println("What is name");
		List<Employees> employees = employeesRepository.findCPFByNameNativeQuery(scanner.next());
		for (Employees employee : employees) {
			Integer cpf = employee.getCPF();
			System.out.println(cpf);
		}
	}

	private void findByName(Scanner scanner) {
		System.out.println("What is name");
		List<Employees> employees = employeesRepository.findByName(scanner.next());
		for (Employees employee : employees) {
			System.out.println(employee.getName());
		}
	}
	
	private void findSalaryByNameJPQL(Scanner scanner) {
		System.out.println("What is name");
		List<Employees> employees = employeesRepository.findSalaryByNameJPQL(scanner.next());
		for (Employees employee : employees) {
			Double salary = employee.getSalary();
			System.out.println(salary);
		}
	}

	public void findCPFandNameByProjection(Scanner scanner) {
		System.out.println("What is id");
		List<EmployessProjection> employees = employeesRepository.findCPFandNameByProjection(scanner.nextInt());
		for (EmployessProjection employee : employees) {
			Integer cpf = employee.getCPF();
			String name = employee.getName();
			System.out.println("Name: "+name);
			System.out.println("CPF: "+cpf);
		}
		
	}
}
