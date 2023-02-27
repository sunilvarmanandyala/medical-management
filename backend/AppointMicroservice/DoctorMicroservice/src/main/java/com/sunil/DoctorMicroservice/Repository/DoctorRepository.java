package com.sunil.DoctorMicroservice.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sunil.DoctorMicroservice.Entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
	public Doctor findByusername(String username);
	public Doctor findByusernameEqualsIgnoreCase(String username);
	public Doctor findByDoctorPhNo(String doctorPhNo);
	
}