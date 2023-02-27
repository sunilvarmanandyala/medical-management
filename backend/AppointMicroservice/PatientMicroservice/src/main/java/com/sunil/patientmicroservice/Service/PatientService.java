package com.sunil.patientmicroservice.Service;

import java.util.List;

import com.sunil.patientmicroservice.Entity.Patient;
import com.sunil.patientmicroservice.exception.PatientNotFoundException;




public interface PatientService {
	public Patient savePatient(Patient patient) throws Exception;
	public List<Patient> fetchPatientList();
	public Patient fetchPatientByUID(int patient_UID) throws PatientNotFoundException ;
	public void deletePatientByUID(int patient_UID);
	public Patient updatePatient(int patient_UID,Patient patient);
	public List<Patient> fetchByusername(String username);
	List<Patient> findByusername(String username);
	//public ResponseTemplateValueObjects getPatientWithDoctor(Integer patient_UID);
}