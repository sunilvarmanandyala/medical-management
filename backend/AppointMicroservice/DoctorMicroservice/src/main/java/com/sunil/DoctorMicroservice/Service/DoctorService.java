package com.sunil.DoctorMicroservice.Service;


import java.util.List;

import com.sunil.DoctorMicroservice.Entity.Doctor;





public interface DoctorService {
	public Doctor saveDoctor(Doctor pdoctor);
	public List<Doctor> fetchDoctorList();
	public Doctor fetchDoctorById(Integer doctorId);
	public void deleteDoctorById(Integer doctorId);
	public Doctor updateDoctor(Integer doctorId,Doctor doctor);
	public Doctor fetchByusername(String username);
	List<Doctor> findByusername(String username);
}