package com.sunil.patientmicroservice.ServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.mockito.Mockito.mock;

import com.sunil.patientmicroservice.Entity.Patient;
import com.sunil.patientmicroservice.Repository.PatientRepository;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import static org.mockito.Mockito.when;

 @TestInstance(Lifecycle.PER_CLASS)
class PatientServiceImplTest {
	private PatientRepository patientRepository ;
	private PatientServiceImpl patientServiceImpl ;
	private Patient patient ;
	@BeforeAll
    void setup() {
		patientServiceImpl = new PatientServiceImpl();
		patientRepository = mock(PatientRepository.class);
		patientServiceImpl.patientRepository = patientRepository;
		patient = new Patient("Kaushal","varma175","995123597","chennai");	
	}
	@Test
	@DisplayName("saving existing patient")
	void testSavePatient1() {
		String patientPhno = patient.getPatientPhno();
		when(patientRepository.findByPatientPhno(patientPhno)).thenReturn(patient);
		
		Exception thrown = assertThrows(Exception.class, () -> patientServiceImpl.savePatient(patient));
		assertEquals("patient alrteady exist", thrown.getMessage());
	}
	
	@Test
	@DisplayName("saving new patient")
	void testSavePatient2() throws Exception {
		String patientPhno = patient.getPatientPhno();
		when(patientRepository.findByPatientPhno(patientPhno)).thenReturn(null);
		when(patientRepository.save(patient)).thenReturn(patient);
		
		assertEquals(patient, patientServiceImpl.savePatient(patient));
		
		
	}

//	@Test
//	@DisplayName("fetching data for new patient")
//	void testFetchPatientByUID() {
//		String patient = patient.getPatient_UID();
//		Optional<Patient> patient = patientRepository.findById(patient_UID);
//		
//		
//	}
	@Test
	void testFetchPatientList() {
		
	}

	@Test
	void testDeletePatientByUID() {
		
	}

	@Test
	void testUpdatePatient() {
		
	}

	@Test
	void testFetchByPatientName() {
		
	}

}
