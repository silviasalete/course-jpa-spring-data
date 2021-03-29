package com.company.specification;

import java.util.Date;

import org.springframework.data.jpa.domain.Specification;

import com.company.model.Employees;

public class SpecificationEmployees {

	public static Specification<Employees> name(String name) {
		return(root, criteriaQuery, criteriaBuilder) ->
		criteriaBuilder.like(root.get("name"), "%"+name+"%");
	}

//	public static Specification<Employees> CPF(Integer CPF) {
//		return(root, criteriaQuery, criteriaBuilder) ->
//		criteriaBuilder.equal(root.get("CPF"), CPF);
//	}

	public static Specification<Employees> salary(Double salary) {
		return(root, criteriaQuery, criteriaBuilder) ->
		criteriaBuilder.greaterThan(root.get("salary"), salary);
	}

//	public static Specification<Employees> hiringDate(Date hiringDate) {
//		return(root, criteriaQuery, criteriaBuilder) ->
//		criteriaBuilder.greaterThan(root.get("hiringDate"), hiringDate);
//	}
}
