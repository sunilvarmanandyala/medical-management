package com.sunil.DoctorMicroservice.ServiceImpl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunil.DoctorMicroservice.Entity.Doctor;
import com.sunil.DoctorMicroservice.Repository.DoctorRepository;


@Service
public class DoctorServiceImpl {
	@Autowired
	public DoctorRepository doctorRepository;
	public Doctor saveDoctor(Doctor doctor) throws Exception
	{
		String doctorPhNo = doctor.getDoctorPhNo();
		Doctor existingDoctor = doctorRepository.findByDoctorPhNo(doctorPhNo);
		
		if (existingDoctor == null) {
			return doctorRepository.save(doctor);
		}
		else {
			throw new Exception("Doctor data already exists");
		}
		
	}
	public List<Doctor> fetchDoctorList()
	{
		return doctorRepository.findAll();
	}
	public Doctor fetchDoctorById(Integer doctorId)
	{
		return doctorRepository.findById(doctorId).get();
	}
	public void deleteDoctorById(Integer doctorId)
	{
		doctorRepository.deleteById(doctorId);
	}
	public Doctor updateDoctor(Integer doctorId,Doctor doctor)
	{
		Doctor docDB = doctorRepository.findById(doctorId).get();
		if(Objects.nonNull(doctor.getUsername())&&
				!"".equalsIgnoreCase(doctor.getUsername()))
		{
			docDB.setUsername(doctor.getUsername());
		}
		if(Objects.nonNull(doctor.getPassword())&&
				!"".equalsIgnoreCase(doctor.getPassword()))
		{
			docDB.setPassword(doctor.getPassword());
		}
		if(Objects.nonNull(doctor.getDoctorPhNo())&&
				!"".equalsIgnoreCase(doctor.getDoctorPhNo()))
		{
			docDB.setDoctorPhNo(doctor.getDoctorPhNo());;
		}
		if(Objects.nonNull(doctor.getExperience())&&
				!"".equalsIgnoreCase(doctor.getExperience()))
		{
			docDB.setExperience(doctor.getExperience());
		}
		if(Objects.nonNull(doctor.getSpecilization())&&
				!"".equalsIgnoreCase(doctor.getSpecilization()))
		{
			docDB.setSpecilization(doctor.getSpecilization());
		}
		return doctorRepository.save(docDB);
	}
	public Doctor fetchByusername(String username)
	{
		return doctorRepository.findByusername(username);
	}
}