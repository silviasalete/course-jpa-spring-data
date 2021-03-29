package com.company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.company.model.Employees;
import com.company.model.EmployessProjection;

@Repository
public interface EmployeesRepository extends PagingAndSortingRepository<Employees, Integer>, JpaSpecificationExecutor<Employees> {

	List<Employees> findByName(String name);
	
	@Query("SELECT e FROM Employees e WHERE e.name = :name")
	List<Employees> findSalaryByNameJPQL(String name);
	
	@Query(value = "SELECT * FROM bd_account.employees WHERE name = :name", nativeQuery = true)
	List<Employees> findCPFByNameNativeQuery(String name);
	
	@Query(value = "SELECT cpf, name FROM bd_account.employees WHERE id = :id", nativeQuery = true)
	List<EmployessProjection> findCPFandNameByProjection(int id);
}
