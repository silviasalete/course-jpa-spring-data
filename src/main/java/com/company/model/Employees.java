package com.company.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Employees {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Integer CPF;
	private Double salary;
	private Date hiringDate;
	
	@ManyToOne
	private Function function;
	@ManyToOne
	private WorkUnity workUnity;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCPF() {
		return CPF;
	}
	public void setCPF(Integer cPF) {
		CPF = cPF;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Date getHiringDate() {
		return hiringDate;
	}
	public void setHiringDate(Date hiringDate) {
		this.hiringDate = hiringDate;
	}
	
	public Function getFunction() {
		return function;
	}
	public void setFunction(Function function) {
		this.function = function;
	}
	public WorkUnity getWorkUnity() {
		return workUnity;
	}
	public void setWorkUnity(WorkUnity workUnity) {
		this.workUnity = workUnity;
	}
	@Override
	public String toString() {
		return "Employees [id=" + id + ", name=" + name + ", CPF=" + CPF + ", salary=" + salary + ", hiringDate="
				+ hiringDate + ", function=" + function.getDescription() + ", workUnity=" + workUnity.getDescription() + "]";
	}
	

}
