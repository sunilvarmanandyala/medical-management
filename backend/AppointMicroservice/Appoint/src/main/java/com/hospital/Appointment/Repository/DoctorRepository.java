package com.hospital.Appointment.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.Appointment.Entity.Doctor;


@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
	public Doctor findByusername(String username);
	public Doctor findByusernameEqualsIgnoreCase(String username);
	public Doctor findByDoctorPhNo(String doctorPhNo);
	
}