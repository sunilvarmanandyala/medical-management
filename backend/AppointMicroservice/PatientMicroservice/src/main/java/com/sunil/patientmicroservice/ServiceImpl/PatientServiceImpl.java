package com.sunil.patientmicroservice.ServiceImpl;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunil.patientmicroservice.Entity.Patient;
import com.sunil.patientmicroservice.Repository.PatientRepository;
import com.sunil.patientmicroservice.Service.PatientService;
import com.sunil.patientmicroservice.exception.PatientNotFoundException;
//import org.springframework.web.client.RestTemplate;

@Service
public class PatientServiceImpl implements PatientService{
	@Autowired
	public PatientRepository patientRepository;
	//@Autowired
	//private RestTemplate restTemplate;
	public Patient savePatient(Patient patient) throws Exception
	{
		
		try {
			String patientPhno = patient.getPatientPhno();
			Patient existingPatient = patientRepository.findByPatientPhno(patientPhno);
			System.out.println(existingPatient);
			System.out.println(existingPatient == null);
			if (existingPatient == null) {

				return patientRepository.save(patient);
			} 
			else {
				throw new Exception("already exists");
			}
		}
		catch (Exception e)
		{
			throw new Exception("no patient found");
		}
//		return "something wrong with patient";
	
//			 throw new Exception("patient already exist"); 
		
	}
    public List<Patient> fetchPatientList()
    {
    	return patientRepository.findAll();
    }
    public Patient fetchPatientByUID(int patient_UID)  throws PatientNotFoundException
    {
    	Optional<Patient> patient = patientRepository.findById(patient_UID);
    	if (!patient.isPresent()) {
    		throw new PatientNotFoundException("Patient not found with Id : "+patient_UID);
			
		}
    	return patient.get();
    }
    public void deletePatientByUID(int patient_UID)
    {
    	patientRepository.deleteById(patient_UID);
    }
    public Patient updatePatient( int patient_UID, Patient patient)
    {
    	Patient patDB = patientRepository.findById(patient_UID).get();
    	if(Objects.nonNull(patient.getUsername())&&
    			!"".equalsIgnoreCase(patient.getUsername()))
    	{
    		patDB.setUsername(patient.getUsername());
    	}
    	if(Objects.nonNull(patient.getPassword())&&
    			!"".equalsIgnoreCase(patient.getPassword()))
    	{
    		patDB.setPassword(patient.getPassword());
    	}
    	if(Objects.nonNull(patient.getPatientAddress())&&
    			!"".equalsIgnoreCase(patient.getPatientAddress()))
    	{
    		patDB.setPatientAddress(patient.getPatientAddress());;
    	}
    	if(Objects.nonNull(patient.getPatientPhno())&&
    			!"".equalsIgnoreCase(patient.getPatientPhno()))
    	{
    		patDB.setPatientPhno(patient.getPatientPhno());;
    	}
    	return patientRepository.save(patDB);
    }
//    public Patient fet(String username)
//    {
//    	return patientRepository.fetchByusername(username);
//    }
//	public ResponseTemplateValueObjects getPatientWithDoctor(Integer patient_UID) {
//		 TODO Auto-generated method stub
//		ResponseTemplateValueObjects vo = new ResponseTemplateValueObjects();
//		Patient patient = patientRepository.findByPatient_UID(patient_UID);
//		Doctor doctor = restTemplate.getForObject("http://localhost:8080/"+patient.getDoctorId(),Doctor.class);
//		vo.setPatient(patient);
//		vo.setDoctor(doctor);
//		return vo;
//	}
	@Override
	public List<Patient> fetchByusername(String username) {
		// TODO Auto-generated method stub
		return patientRepository.findByusername(username);
	}
//	@Override
//	public List<Patient> findByusername(String username) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	@Override
	public List<Patient> findByusername(String username) {
		// TODO Auto-generated method stub
		return null;
	}
}