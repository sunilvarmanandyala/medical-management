package com.hospital.Appointment.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
@Table(name="doctorlist")
public class Doctor {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer doctor_Id;
    @NotBlank(message = "user name should not be empty")
	private String username;
//@NotBlank(message = "password should not be empty")
	private String password;
//	@Pattern(regexp="^//d{10}$",message="Incorrect Number Will be Entered")
	private String doctorPhNo;
	@NotNull(message = "doctor specilization should not be empty")
	private String specilization;
//	@NotBlank(message = " experience should not be empty")
	private String experience;
	
	@JsonBackReference
	@ManyToMany(mappedBy = "doctors", fetch = FetchType.LAZY)
	private List<Appointment> appointments = new ArrayList<Appointment>();
	
	public Doctor(Integer doctor_Id, String username, String password, String doctorPhNo, String specilization, String experience) {
		super();
		this.doctor_Id = doctor_Id;
		this.username = username;
		this.password = password;
		this.doctorPhNo = doctorPhNo;
		this.specilization = specilization;
		this.experience = experience;
	}
	public Doctor()
	{
		
	}
	public List<Appointment> getAppointments() {
		return appointments;
	}
	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	public void addappointments(Appointment appointment) 
	{
	 	appointments.add(appointment);
	}
	public Integer getDoctor_Id() {
		return doctor_Id;
	}
	public void setDoctor_Id(Integer doctor_Id) {
		this.doctor_Id = doctor_Id;
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
	public String getDoctorPhNo() {
		return doctorPhNo;
	}
	public void setDoctorPhNo(String doctorPhNo) {
		this.doctorPhNo = doctorPhNo;
	}
	public String getSpecilization() {
		return specilization;
	}
	public void setSpecilization(String specilization) {
		this.specilization = specilization;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	@Override
	public String toString() {
		return "Doctor [doctor_Id=" + doctor_Id + ", username=" + username + ", password= "+ password +" ,doctorPhNo=" + doctorPhNo
				+ ", specilization =" + specilization + ", experience = "+ experience+ "]";
	}
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
}