package com.hospital.Appointment;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hospital.Appointment.Entity.Appointment;
import com.hospital.Appointment.Repository.AppointmentRepository;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AppointmentApplicationTests {
	
//	@Autowired
//	AppointmentRepository appointRepo;
//	
//	@Test
//	public void testCreate() {
//		Appointment a = new Appointment();
////		a.setId(25);
//		a.setConformation("No");
//		a.setAppointmentType("Dermotologiist");
//		a.setAppointmentDate("12-9-2022");
//		a.setPatientname("yash");
//		a.setDoctorname("Dr.prabhas");
//		appointRepo.save(a);
//		assertThat(appointRepo.findByDoctorname("Dr.prabhas")).isNotEmpty();
//	}
}
