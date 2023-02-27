package com.sunil.patientmicroservice.Controller;

public class appointmentData {

	private String doctorname;
	private String patientname;
	private String appointmentDate;
	private String appointmentType;
	private String Conformation;
	public String getDoctorname() {
		return doctorname;
	}
	public void setDoctername(String doctorname) {
		this.doctorname = doctorname;
	}
	public String getPatientname() {
		return patientname;
	}
	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}
	public String getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getAppointmentType() {
		return appointmentType;
	}
	public void setAppointmentType(String appointmentType) {
		this.appointmentType = appointmentType;
	}
	public String getConformation() {
		return Conformation;
	}
	public void setConformation(String conformation) {
		Conformation = conformation;
	}
	
	
	
}
