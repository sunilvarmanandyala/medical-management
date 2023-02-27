package com.sunil.DoctorMicroservice.Controller;


import java.util.List;

import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sunil.DoctorMicroservice.Entity.Doctor;
import com.sunil.DoctorMicroservice.ServiceImpl.DoctorServiceImpl;



@RestController
@CrossOrigin
public class DoctorController {
	private RestTemplate restTemp;
    @Autowired
    public DoctorController(RestTemplateBuilder builder) {
        this.restTemp = builder.build();
    }
    
	@Autowired
	private DoctorServiceImpl doctorService;
	@PostMapping("/doctoradd") //Create Doctor Details
	public Doctor saveDoctor(@RequestBody Doctor doctor) throws Exception
	{
		return doctorService.saveDoctor(doctor);
	}
	@GetMapping("/doctorappointment/{doctorname}")
	public List<appointmentData> doctorappointment(@PathVariable ("doctorname") String doctorname)
	{
		return restTemp.getForObject("http://localhost:9093/doctorappointment/"+doctorname,List.class);
	}
	@GetMapping("/Getdoctor") // Get Doctor Details
	public List<Doctor> fetchDoctorList()
	{
		return doctorService.fetchDoctorList();
	}
	@GetMapping("/doctor/{id}") //Get Doctor Details by doctorI Id
	public Doctor fetchDoctorById(@PathVariable("id") Integer doctor_Id)
	{
		return doctorService.fetchDoctorById(doctor_Id);
	}
	@DeleteMapping("/doctor/{id}") //Delete Doctor Details by doctor id
	public String deleteDoctorById(@PathVariable("id") Integer doctor_Id)
	{
		doctorService.deleteDoctorById(doctor_Id);
		return "Doctor Deleted Successfully";
	}
	@PutMapping("/doctor/{id}") //update doctor Details by doctor id
	public Doctor updateDoctor(@PathVariable("id") Integer doctor_Id,@RequestBody Doctor doctor)
	{
		return doctorService.updateDoctor(doctor_Id, doctor);
	}
	@GetMapping("/doctor/name/{name}") //Get doctor details by doctor Name
	public Doctor fetchByusername(@PathVariable("name") String username)
	{
		return doctorService.fetchByusername(username);
	}
}