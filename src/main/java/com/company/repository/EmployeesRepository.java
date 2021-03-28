package com.company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.company.model.Employees;

@Repository
public interface EmployeesRepository extends PagingAndSortingRepository<Employees, Integer> {

	List<Employees> findByName(String name);
	
	@Query("SELECT e FROM Employees e WHERE e.name = :name")
	List<Employees> findSalaryByNameJPQL(String name);
	
	@Query(value = "SELECT * FROM bd_account.employees WHERE name = :name", nativeQuery = true)
	List<Employees> findCPFByNameNativeQuery(String name);
}
