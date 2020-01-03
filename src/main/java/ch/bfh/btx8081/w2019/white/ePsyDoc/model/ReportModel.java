package ch.bfh.btx8081.w2019.white.ePsyDoc.model;

import java.util.ArrayList;
import java.util.List;

import ch.bfh.btx8081.w2019.white.ePsyDoc.database.Service;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Diagnosis;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Doctor;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Medication;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Patient;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.PatientCase;

public class ReportModel {
	private List<Patient> patientList = new ArrayList<Patient>();
	private List<PatientCase> patientCaseList = new ArrayList<PatientCase>();
	private List<Medication> medicationList = new ArrayList<Medication>();
	private List<Diagnosis> diagnosisList = new ArrayList<Diagnosis>();

	private Service<Patient> patientService = new Service<>(new Patient());
	private Service<PatientCase> patientCaseService = new Service<>(new PatientCase());
	private Service<Medication> medicationService = new Service<>(new Medication());
	private Service<Diagnosis> diagnosisService = new Service<>(new Diagnosis());
	
	private PatientCase patientCase;

	
	public void changePatientCase(int patientCaseID, String consultation) {
		
	}
	
	public void addMedication(Medication medication) {

	}

	public void removeMedication(int medicationID) {

	}

	public void addDiagnosis(Diagnosis diagnosis) {

	}

	public void removeDiagnosis(int diagnosisID) {

	}

	public void addPatientCase(Patient patient, Doctor doctor) {

	}
	

	public PatientCase getPatientCase() {
		return patientCase;
	}

	public void setPatientCase(int patientCaseID) {
		this.patientCase = patientCaseService.findByAttributeFirstElem("patientCaseID", patientCaseID);
	}
	
	public void setPatientCaseToLastPatientCase(int patientCaseID) {
		this.patientCase= patientCaseService.findLastElem("patientCaseID",patientCaseID);
	}

	public void removePatientCase(int patientCaseID) {

	}

	public List<Patient> getPatientList() {
		return patientList;
	}

	public void setPatientList(List<Patient> patientList) {
		this.patientList = patientList;
	}

	public List<PatientCase> getPatientCaseList() {
		return patientCaseList;
	}

	public void setPatientCaseList(int patientID) {
		this.patientCaseList = patientCaseService.findByAttributFullDESC("patient.patientID", patientID, "patient.patientID");
	}

	public List<Medication> getMedicationList() {
		return medicationList;
	}

	public void setMedicationList(List<Medication> medicationList) {
		medicationList = medicationList;
	}

	public List<Diagnosis> getDiagnosisList() {
		return diagnosisList;
	}

	public void setDiagnosisList(List<Diagnosis> diagnosisList) {
		diagnosisList = diagnosisList;
	}
}
