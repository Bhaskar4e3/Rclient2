package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Pupil {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int student_id;
	private String student_name;
	private String student_address;
	private String student_contact;
	
	public Pupil() {}

	public Pupil(int student_id, String student_name, String student_address, String student_contact) {
		super();
		this.student_id = student_id;
		this.student_name = student_name;
		this.student_address = student_address;
		this.student_contact = student_contact;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getStudent_address() {
		return student_address;
	}

	public void setStudent_address(String student_address) {
		this.student_address = student_address;
	}

	public String getStudent_contact() {
		return student_contact;
	}

	public void setStudent_contact(String student_contact) {
		this.student_contact = student_contact;
	}

	@Override
	public String toString() {
		return "Pupil [student_id=" + student_id + ", student_name=" + student_name + ", student_address="
				+ student_address + ", student_contact=" + student_contact + "]";
	}

}
