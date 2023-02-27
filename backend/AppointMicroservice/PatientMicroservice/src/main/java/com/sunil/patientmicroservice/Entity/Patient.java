package com.sunil.patientmicroservice.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Entity
@Table(name="patientlist")
public class Patient {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int patient_UID;
	@NotBlank(message = "Patient name should not be empty")
	private String username;
	@NotBlank(message = "password should not be empty")
	private String password;
	@NotNull(message = "Patient address should not be null")
	private String patientAddress;
//	@Pattern(regexp="^//d{10}$",message="Incorrect Number Will be Entered")
	private String patientPhno;
	
	public Patient( String username, String password,  String patientAddress, String patientPhno) {
		super();
		this.username = username;
		this.password = password;
		this.patientAddress = patientAddress;
		this.patientPhno = patientPhno;
	}
	public Patient() {
		super();
	}
	public int getPatient_UID() {
		return patient_UID;
	}
	public void setPatient_UID(int patient_UID) {
		this.patient_UID = patient_UID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPatientPhno() {
		return patientPhno;
	}
	public void setPatientPhno(String patientPhno) {
		this.patientPhno = patientPhno;
	}
	public String getPatientAddress() {
		return patientAddress;
	}
	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}
	@Override
	public String toString() {
		return "Patient [patient_UID=" + patient_UID + ", username=" + username + ", password= "+ password +" ,patientAddress=" + patientAddress
				+ ", patientPhno=" + patientPhno + "]";
	}
	
}