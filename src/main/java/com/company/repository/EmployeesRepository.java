package com.company.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.company.model.Employees;

@Repository
public interface EmployeesRepository extends CrudRepository<Employees, Integer> {

	List<Employees> findByName(String name);
}
