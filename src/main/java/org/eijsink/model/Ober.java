package org.eijsink.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Ober{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String employeeId;
	private LocalDate dateOfBirth;

	public Ober() {
	}

	public Ober(String employeeId, String name, LocalDate dateOfBirth) {
		this.employeeId = employeeId;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}

	public long getId(){
		return id;
	}
	public void setId( long id){
		this.id = id;
	}
	public String getEmployeeId(){ 
		return employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmployeeId( String employeeId){
		this.employeeId = employeeId;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}
