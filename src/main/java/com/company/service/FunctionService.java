package com.company.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.company.model.Function;
import com.company.repository.FunctionRepository;

@Service
public class FunctionService {

	private final FunctionRepository functionRepository;

	public FunctionService(FunctionRepository functionRepository) {
		this.functionRepository = functionRepository;
	}
	
	public void initial(Scanner scanner) {
		
		System.out.println("What action do you want to make?");
		System.out.println("0 - Sair");
		System.out.println("1 - Salve");
		System.out.println("2 - Update");
		System.out.println("3 - View");
		System.out.println("4 - Delete");
		
		switch (scanner.nextInt()) {
		
		case 1:
			save(scanner);
			break;
			
		case 2:
			update(scanner);
			break;
			
		case 3:
			view();
			break;
				
		case 4:
			delete(scanner);
		break;
		
		default:
			break;
		}
	}

	private void view() {
		
		Iterable<Function> functions = this.functionRepository.findAll();
		
		functions.forEach(function -> {
			System.out.println(function.toString());
		});
		
	}

	private void save(Scanner scanner) {
		
		Function function = new Function();
		
		System.out.println("Job description:");
		function.setDescription(scanner.next());
		
		functionRepository.save(function);
		System.out.println("Job description salved!!!");
	}
	
	private void update(Scanner scanner) {
		
		Function function = new Function();
		
		System.out.println("Job Id:");
		function.setId(scanner.nextInt());;
		
		System.out.println("Job description:");
		function.setDescription(scanner.next());
		
		functionRepository.save(function);
		System.out.println("Job description updated!!!");
	}
	
	private void delete(Scanner scanner) {
		
		System.out.println("Job Id:");
		Integer id = scanner.nextInt();
		
		functionRepository.deleteById(id);
	}
}
