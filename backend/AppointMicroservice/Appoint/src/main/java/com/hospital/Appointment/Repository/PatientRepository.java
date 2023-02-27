package com.hospital.Appointment.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.Appointment.Entity.Patient;



@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
	public List<Patient> findByusername(String username);
	public Patient findByusernameIgnoreCase(String username);
//    public Patient findByPatient_UID(Integer patient_UID);
//	public List<Patient> findByusernameAnduserAddress(String username , String patientAddress);
	public Patient findByPatientPhno(String patientPhno);
	
}
