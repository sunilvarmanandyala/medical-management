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

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="appPatient")
public class Appointment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
//  @NotBlank(message = "Patient id should not be empty")
	private int id;
//	@NotBlank(message = "Patient name should not be empty")
	private String patientname;
//	@NotBlank(message = "Doctor name should not be empty")

	private String doctorname;
	private String appointmentType;
	private String appointmentDate;
	@NotNull(message = "Appointment Conformation should not be null")
	private String Conformation;
	
	@JsonManagedReference
	@ManyToMany
	private List<Doctor> doctors = new ArrayList<Doctor>();
	@ManyToMany
	private List<Patient> patients = new ArrayList<Patient>();
	
	public Appointment(int id, String patientname, String doctorname, String appointmentType,
			String appointmentDate, String conformation ) {
		super();
		this.id = id;
		this.patientname = patientname;
		this.doctorname = doctorname;
		this.appointmentType = appointmentType;
		this.appointmentDate = appointmentDate;
		this.Conformation = conformation;
	}
	public Appointment() {
		super();
	}
	public void addpatients(Patient patient)
	{
		patients.add(patient);
	}
	public void adddoctors(Doctor doctor)
	{
		doctors.add(doctor);
	}
	public int id() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Doctor> getDoctors() {
		return doctors;
	}
	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}
	public List<Patient> getPatients() {
		return patients;
	}
	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
	public int getId() {
		return id;
	}
	public String getPatientname() {
		return patientname;
	}
	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}
	public String getDoctorname() {
		return doctorname;
	}
	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}
	public String getAppointmentType() {
		return appointmentType;
	}
	public void setAppointmentType(String appointmentType) {
		this.appointmentType = appointmentType;
	}
	public String getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getConformation() {
		return Conformation;
	}
	public void setConformation(String conformation) {
		Conformation = conformation;
	}
	
	
	public Appointment orElseThrow(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
