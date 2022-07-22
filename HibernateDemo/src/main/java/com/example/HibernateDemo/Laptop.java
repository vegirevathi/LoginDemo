package com.example.HibernateDemo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Laptop {

	@Id
	private String laptopId;
	private String laptopCompany;
	@ManyToMany(mappedBy = "laptop")
	private List<Student> student = new ArrayList();
	
	
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	public String getLaptopId() {
		return laptopId;
	}
	public void setLaptopId(String laptopId) {
		this.laptopId = laptopId;
	}
	public String getLaptopCompany() {
		return laptopCompany;
	}
	public void setLaptopCompany(String laptopCompany) {
		this.laptopCompany = laptopCompany;
	}
	
	
}
