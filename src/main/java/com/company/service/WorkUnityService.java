package com.company.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.company.model.WorkUnity;
import com.company.repository.WorkUnityRepository;

@Service
public class WorkUnityService {

	private WorkUnityRepository workUnityRepository;
	
	public WorkUnityService(WorkUnityRepository workUnityRepository) {
		this.workUnityRepository = workUnityRepository;
	}

	public void initial(Scanner scanner) {
		
		System.out.println("What action do you want to take?");
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
			view();
			break;
		case 4:
			delete(scanner);
			break;

		default:
			break;
		}
	}

	private void delete(Scanner scanner) {

		System.out.println("What is the ID?");
		this.workUnityRepository.deleteById(scanner.nextInt());

		System.out.println("WorkUnity DELETED!!!");
	}

	private void view() {
		Iterable<WorkUnity> findAll = this.workUnityRepository.findAll();

		System.out.println("---------------- WorkUnity ---------------");
		findAll.forEach(workUnity -> {
			System.out.println(workUnity.toString());
		});
		
	}

	private void update(Scanner scanner) {
		
		WorkUnity workUnity = new WorkUnity();
		
		System.out.println("What is the ID?");
		workUnity.setId(scanner.nextInt());
		
		System.out.println("What is the description?");
		workUnity.setDescription(scanner.next());
		
		System.out.println("What is the address?");
		workUnity.setAddress(scanner.next());
		
		this.workUnityRepository.save(workUnity);
		System.out.println("WorkUnity UPDATED!!!");
	}

	private void save(Scanner scanner) {
		
		WorkUnity workUnity = new WorkUnity();
		
		System.out.println("What is the description?");
		workUnity.setDescription(scanner.next());
		
		System.out.println("What is the address?");
		workUnity.setAddress(scanner.next());
		
		this.workUnityRepository.save(workUnity);
		System.out.println("WorkUnity SALVED!!!");
	}
	
}
