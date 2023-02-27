package com.hospital.Appointment.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hospital.Appointment.Entity.Appointment;
@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, String> {

	Appointment findById(int appointment_Id);

	

	List<Appointment> findByDoctorname(String doctorname);

	void deleteById(Integer appointment_Id);
	
}
