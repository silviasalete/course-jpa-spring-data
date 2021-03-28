package com.company.service;

import java.util.Date;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.company.model.Employees;
import com.company.model.Function;
import com.company.model.WorkUnity;
import com.company.repository.EmployeesRepository;
import com.company.repository.FunctionRepository;
import com.company.repository.WorkUnityRepository;

@Service
public class EmployeesService {
	
	private EmployeesRepository employeesRepository;
	private FunctionRepository functionRepository;
	private WorkUnityRepository workUnityRepository;
	
	public EmployeesService(EmployeesRepository employeesRepository,FunctionRepository functionRepository, WorkUnityRepository workUnityRepository) {
		
		this.employeesRepository = employeesRepository;
		this.functionRepository = functionRepository;
		this.workUnityRepository = workUnityRepository;
	}

	public void initial(Scanner scanner) {
		System.out.println("What action do you want to perform?");
		System.out.println("1 - Save");
		System.out.println("2 - Update");
		System.out.println("3 - View");
		System.out.println("4 - Delete");
		
		int action = scanner.nextInt();
		
		switch (action) {
		
		case 1:
			save(scanner);
			break;

		case 2:
			update(scanner);
			break;

		case 3:
			view(scanner);
			break;

		case 4:
			delete(scanner);
			break;
			
		default:
			break;
		}
	}

	private void delete(Scanner scanner) {
		
		System.out.println("Employee Id:");
		employeesRepository.deleteById(scanner.nextInt());
	}

	private void view(Scanner scanner) {
		System.out.println("What page do you want to view?");
		Integer numberPage = scanner.nextInt();
		Pageable pageable = PageRequest.of(numberPage, 2, Sort.unsorted());
		
		Page<Employees> employees = employeesRepository.findAll(pageable);
		
		System.out.println("Page current "+employees.getNumber());
		System.out.println("Total Elements "+employees.getTotalElements());
		employees.forEach(employee -> {
			System.out.println(employee.toString());
		});
	}

	private void update(Scanner scanner) {

		Employees employees = new Employees();
		
		System.out.println("Employee Id:");
		employees.setId(scanner.nextInt());
		System.out.println("Which employee name?");
		employees.setName(scanner.next());
		System.out.println("Which employee CPF?");
		employees.setCPF(scanner.nextInt());;
		System.out.println("Which employee salary?");
		employees.setSalary(scanner.nextDouble());
		System.out.println("Which function?");
		Iterable<Function> findAll = functionRepository.findAll();
		findAll.forEach(function -> {
			System.out.println(function.getId()+" - "+function.getDescription());
		});
		Optional<Function> function = functionRepository.findById(scanner.nextInt());
		employees.setFunction(function.get());
		
		System.out.println("Which work unity?");
		Iterable<WorkUnity> findAllWorkUnity = workUnityRepository.findAll();
		findAllWorkUnity.forEach(workUnity -> {
			System.out.println(workUnity.getId()+" - "+workUnity.getDescription());
		});
		Optional<WorkUnity> workUnity = workUnityRepository.findById(scanner.nextInt());
		employees.setWorkUnity(workUnity.get());
		
//		System.out.println("What is the employee's hiring date?");	
		Date today = new Date();
		employees.setHiringDate(today);
		
		employeesRepository.save(employees);
	}

	private void save(Scanner scanner) {
		Employees employees = new Employees();
		
		System.out.println("Which employee name?");
		employees.setName(scanner.next());
		System.out.println("Which employee CPF?");
		employees.setCPF(scanner.nextInt());
		System.out.println("Which employee salary?");
		employees.setSalary(scanner.nextDouble());

		System.out.println("Which function?");
		Iterable<Function> findAll = functionRepository.findAll();
		findAll.forEach(function -> {
			System.out.println(function.getId()+" - "+function.getDescription());
		});
		Optional<Function> function = functionRepository.findById(scanner.nextInt());
		employees.setFunction(function.get());
		
		System.out.println("Which work unity?");
		Iterable<WorkUnity> findAllWorkUnity = workUnityRepository.findAll();
		findAllWorkUnity.forEach(workUnity -> {
			System.out.println(workUnity.getId()+" - "+workUnity.getDescription());
		});
		Optional<WorkUnity> workUnity = workUnityRepository.findById(scanner.nextInt());
		employees.setWorkUnity(workUnity.get());
		
//		System.out.println("What is the employee's hiring date?");	
		Date today = new Date();
		employees.setHiringDate(today);
		
		employeesRepository.save(employees);
		
	}
}
