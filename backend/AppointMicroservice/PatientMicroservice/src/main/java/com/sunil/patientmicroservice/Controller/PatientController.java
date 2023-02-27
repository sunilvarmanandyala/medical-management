package com.sunil.patientmicroservice.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hospital.Appointment.Entity.Appointment;
import com.sunil.patientmicroservice.Entity.Patient;
import com.sunil.patientmicroservice.ServiceImpl.PatientServiceImpl;
import com.sunil.patientmicroservice.exception.PatientNotFoundException;
import com.sunil.patientmicroservice.helper.JwtUtil;

import ch.qos.logback.classic.pattern.Util;



@RestController
@CrossOrigin
public class PatientController {
	private RestTemplate restTemp;
    @Autowired
    public PatientController(RestTemplateBuilder builder) {
        this.restTemp = builder.build();
    }
//    @Autowired
//    private JwtUtil Util;
//    HttpServletRequest request
//    @RequestHeader("Authorization") String token
    
    @PostMapping("/BookAppointment")
	public boolean bookAppointment(@RequestBody appointmentData Data) {
//    	Data.setPatientname(token);
    	
//    	String token = request.getHeader("Authorization").split(" ")[1].trim();
//    	Data.setPatientname(Util.extractUsername(token));
		return restTemp.getForObject("http://localhost:9093/appoint/"+Data.getPatientname()+"/"+Data.getDoctorname()+"/"+Data.getAppointmentDate()+"/"+Data.getAppointmentType()+"/"+Data.getConformation(), Boolean.class);
	}
	@Autowired
	private PatientServiceImpl patientService;
	@PostMapping("/patientsadd") //Create patient Details
	public Patient savePatient(@RequestBody @Valid Patient patient) throws Exception

	{
		return patientService.savePatient(patient);
	}
	@GetMapping("/Getpatients") //Get Patient Details
	public List<Patient> fetchPatientList()
	{
		return patientService.fetchPatientList();
	}
	@GetMapping("/patients/{id}") //Get patient Details by patientId
	public Patient fetchPatientByUID(@PathVariable("id") int patient_UID) throws PatientNotFoundException
	{
		return patientService.fetchPatientByUID(patient_UID);
		
	}
	@DeleteMapping("/patients/{id}") //Delete patient details by patientId
	public String deletePatientByUID(@PathVariable("id") int patient_UID)
	{
		patientService.deletePatientByUID(patient_UID);
		return "Delete patient Service is successfully";
	}
	@PutMapping("/patients/{id}") //update patient details by patientID
	public Patient updatePatient(@PathVariable("id") int patient_UID,@RequestBody Patient patient)
	{
		return patientService.updatePatient(patient_UID, patient);
	}
	@GetMapping("/patients/name/{name}") //Get patient Details by patient Name
	public List<Patient> fetchByusername(@PathVariable("name") String username)
	{
		return patientService.fetchByusername(username);
	}
	
	public String exceptionHanderNull() {
		return "null";
	}
	//@GetMapping("/{id}")
	//public ResponseTemplateValueObjects getPatientWithDoctor(@PathVariable("id") Integer patient_UID)
	//{
		//return patientService.getPatientWithDoctor(patient_UID);
	//}
}