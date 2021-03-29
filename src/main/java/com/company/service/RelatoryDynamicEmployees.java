package com.company.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.company.model.Employees;
import com.company.repository.EmployeesRepository;
import com.company.specification.SpecificationEmployees;

@Service
public class RelatoryDynamicEmployees {

	private final EmployeesRepository employeesRepository;
	
	public RelatoryDynamicEmployees(EmployeesRepository employeesRepository) {
		this.employeesRepository = employeesRepository;
	}

	public void initial(Scanner scanner) {
		
		System.out.println("Enter a name: ");
		String name = scanner.next();
		if (name.equalsIgnoreCase("NULL")) {
			name = null;
		}
		
//		System.out.println("Enter a CPF: ");
//		Integer cpf = scanner.nextInt();
//		if (cpf == 0) {
//			cpf = null;
//		}
		
		System.out.println("Enter a Salary: ");
		Double salary = scanner.nextDouble();
		if (salary == 0) {
			salary = null;
		}
		
		
		List<Employees> employees = employeesRepository.findAll(Specification
				.where(
						SpecificationEmployees.name(name))
//						.or(SpecificationEmployees.cpf(cpf))
						.or(SpecificationEmployees.salary(salary))
				);
		employees.forEach(employee -> {
			System.out.println(employee.toString());
		});
	}
}
