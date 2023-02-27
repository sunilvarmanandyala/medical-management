package com.sunil.DoctorMicroservice.ServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.hibernate.query.criteria.internal.expression.SearchedCaseExpression.WhenClause;

import com.fasterxml.jackson.databind.Module.SetupContext;
import com.sunil.DoctorMicroservice.Entity.Doctor;
import com.sunil.DoctorMicroservice.Repository.DoctorRepository;
@TestInstance(Lifecycle.PER_CLASS)
class DoctorServiceImplTest {
	private DoctorRepository doctorRepository;
	private DoctorServiceImpl doctorServiceImpl;
	private Doctor doctor;
	
	@BeforeAll
	void setup() {
		doctorServiceImpl = new DoctorServiceImpl() ;
		doctorRepository = mock(DoctorRepository.class);
		doctorServiceImpl.doctorRepository = doctorRepository;
		doctor = new Doctor(2, "sunil","varma","9951235979","cardiologist","6");
	}


	@Test
	@DisplayName("saving existing doctor")
	void testSaveDoctor1() {
		String doctorPhNo = doctor.getDoctorPhNo();
		when(doctorRepository.findByDoctorPhNo(doctorPhNo)).thenReturn(doctor);
		
		Exception thrown = assertThrows(Exception.class, () -> doctorServiceImpl.saveDoctor(doctor));
		assertEquals("Doctor data already exists",thrown.getMessage());
	}
	
	@Test
	@DisplayName("saving existing doctor")
	void testSaveDoctor2() throws Exception {
		String doctorPhNo = doctor.getDoctorPhNo();
		when(doctorRepository.findByDoctorPhNo(doctorPhNo)).thenReturn(null);
		when(doctorRepository.save(doctor)).thenReturn(doctor);
		
		assertEquals(doctor, doctorServiceImpl.saveDoctor(doctor));
		
	}

	@Test
	void testFetchDoctorList() {
		
	}

	@Test
	void testFetchDoctorById() {
		
	}

	@Test
	void testDeleteDoctorById() {
		
	}

	@Test
	void testUpdateDoctor() {
		
	}

	@Test
	void testFetchByDoctorName() {
		
	}

}
