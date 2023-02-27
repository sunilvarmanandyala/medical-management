package com.hospital.Appointment.Controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.Appointment.Entity.Appointment;
import com.hospital.Appointment.Entity.Doctor;
import com.hospital.Appointment.Repository.AppointmentRepository;
import com.hospital.Appointment.Repository.DoctorRepository;
import com.hospital.Appointment.Repository.PatientRepository;
import com.hospital.Appointment.Service.AppointmentService;


@RestController
@CrossOrigin
public class AppointmentControll {
	@Autowired
	public AppointmentService appointServ;
    @Autowired
    public AppointmentRepository appointRepo;
    @Autowired
    public PatientRepository patientRepo;
    @Autowired
    public DoctorRepository doctorRepo;
//    @PostMapping("/BookAppointment")
//    public Appointment saveAppointment(@RequestBody Appointment appointment) {
//		return appointServ.saveAppointment(appointment);  	
//    }
//	
	@GetMapping("/appoint/")
	public List<Appointment> getAllAppoints(){
		return appointServ.getAllAppoints();
	}
	@GetMapping("/doctorappointment/{doctorname}")
	public List<Appointment> doctorappointment(@PathVariable ("doctorname") String doctorname)
	{
		return appointRepo.findByDoctorname(doctorname).stream().collect(Collectors.toList());
	}
	@GetMapping("/appoint/{id}") //get Appointment Details by Appointment Id
	public Appointment fetchAppointmentById(@PathVariable("id") int id)
	{
		return appointServ.fetchAppointmentById(id);
				
	}
	@GetMapping("/appoint/{patientname}/{doctorname}/{appointmentDate}/{appointmentType}/{Conformation}") //Create Appointments
	public Appointment saveAppointment(@PathVariable("patientname") String patientname,@PathVariable("doctorname") String doctorname,@PathVariable("appointmentDate") String appointmentDate,@PathVariable("appointmentType") String appointmentType,@PathVariable("Conformation") String Conformation)
	{
		Appointment appoint = new Appointment();
		appoint.addpatients(patientRepo.findByusername(patientname).get(0));
		appoint.adddoctors(doctorRepo.findByusername(doctorname));
		
		appoint.setPatientname(patientname);
		appoint.setDoctorname(doctorname);
		appoint.setAppointmentDate(appointmentDate);
		appoint.setAppointmentType(appointmentType);
		appoint.setConformation(Conformation);
		return appointServ.saveAppointment(appoint);
	}
	@DeleteMapping("/appoint/{id}") //deleteAppointment Details By Appointment Id
	public String deleteAppointmentById(@PathVariable("id") int id)
	{
		 appointServ.deleteAppointmentById(id);
		 return "Appointment Deleted Successfully";
	}
	@PostMapping("/Addappoint/") //Create Appointment
	public Appointment addAppointment(@RequestBody Appointment appoint) throws Exception
	{
		return appointServ.addPatient(appoint);
	}
	@PutMapping("/appoint/{id}") // Update Appointment Details by Appointment Id
	public Appointment updateAppointment(@PathVariable("id") int id,@RequestBody Appointment appoint)
	{
		return appointServ.updateAppointment(id, appoint);
	}
	@GetMapping("/appoint/name/{name}") // get Appointment Details by doctorName
	public List<Appointment> fetchByDoctorName(@PathVariable("name") String docName)
	{
		return appointServ.fetchByDoctorName(docName);
	}
	@ExceptionHandler(ConstraintViolationException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
    return new ResponseEntity<>("not valid due to validation error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
  }
}
