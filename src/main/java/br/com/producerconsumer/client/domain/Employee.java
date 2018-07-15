package br.com.producerconsumer.client.domain;

public class Employee {
	
	private Long id;
	private String name;
	private String designation;
	private double salary;
	
	
	public Employee(Long id, String name, String designation, double salary) {
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.salary = salary;
	}
	
	public Long getId() {
		return id;
	}
	public void setEmpId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
}
