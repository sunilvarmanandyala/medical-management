package com.hospital.Appointment.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.Appointment.Entity.Appointment;
import com.hospital.Appointment.Repository.AppointmentRepository;

@Service
public class AppointmentService {
	@Autowired
	private AppointmentRepository AppointRepo;

	public List<Appointment> getAllAppoints() {
		List<Appointment> appoint = new ArrayList<>();
		AppointRepo.findAll().forEach(appoint::add);
		return appoint;
	}

	public Appointment fetchAppointmentById(int id) {
		return AppointRepo.findById(id);
	}

	public Appointment saveAppointment(Appointment appoint) {
		return AppointRepo.save(appoint);
	}

	public void deleteAppointmentById(int id) {
		AppointRepo.deleteById(id);
	}

	public Appointment updateAppointment(int id, Appointment appoint) {
		Appointment appDB = AppointRepo.findById(id);
		if (Objects.nonNull(appoint.getAppointmentDate()) && !"".equalsIgnoreCase(appoint.getAppointmentDate())) {
			appDB.setAppointmentDate(appoint.getAppointmentDate());
		}
		if (Objects.nonNull(appoint.getAppointmentType()) && !"".equalsIgnoreCase(appoint.getAppointmentType())) {
			appDB.setAppointmentType(appoint.getAppointmentType());
		}
		if (Objects.nonNull(appoint.getConformation()) && !"".equalsIgnoreCase(appoint.getConformation())) {
			appDB.setConformation(appoint.getConformation());
		}
		if (Objects.nonNull(appoint.getDoctorname()) && !"".equalsIgnoreCase(appoint.getDoctorname())) {
			appDB.setDoctorname(appoint.getDoctorname());
		}
		if (Objects.nonNull(appoint.getPatientname()) && !"".equalsIgnoreCase(appoint.getPatientname())) {
			appDB.setPatientname(appoint.getPatientname());
		}
		return AppointRepo.save(appDB);
	}

	public List<Appointment> fetchByDoctorName(String docName) {
		return AppointRepo.findByDoctorname(docName);
	}

	public Appointment addPatient(Appointment appoint) {
		// TODO Auto-generated method stub
		return AppointRepo.save(appoint);
	}
}