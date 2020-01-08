package ch.bfh.btx8081.w2019.white.ePsyDoc.model;

import java.util.ArrayList;
import java.util.List;

import ch.bfh.btx8081.w2019.white.ePsyDoc.database.Service;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Diagnosis;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Doctor;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Medication;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Patient;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.PatientCase;

/**
 * Model of Report. Connect to database.
 * 
 * @author Alain Nippel
 * @author Apiwat-David Gaupp
 * @author Janahan Sellathurai
 * @author Marko Miletic
 * @author Sugeelan Selvasingham
 * @author Viktor Velkov
 * 
 * @version 1.0
 */
public class ReportModel {
	private List<Patient> patientList = new ArrayList<Patient>();
	private List<PatientCase> patientCaseList = new ArrayList<PatientCase>();
	private List<Medication> medicationList = new ArrayList<Medication>();
	private List<Diagnosis> diagnosisList = new ArrayList<Diagnosis>();

	private Service<PatientCase> patientCaseService = new Service<>(new PatientCase());
	private Service<Medication> medicationService = new Service<>(new Medication());
	private Service<Diagnosis> diagnosisService = new Service<>(new Diagnosis());
	private Service<Doctor> DoctorService = new Service<>(new Doctor());

	private PatientCase patientCase;
	private Doctor doctor;

	public void changePatientCase(int patientCaseID, String report) {
		patientCaseService.updatePatientCaseReport(patientCaseID, report);
	}

	public void addMedication(Medication medication) {
		medicationService.addMedication(medication);
	}

	public void removeMedication(Medication medication) {
		medicationService.removeMedication(medication);
	}

	public void addDiagnosis(Diagnosis diagnosis) {
		diagnosisService.addDiagnosis(diagnosis);
	}

	public void removeDiagnosis(Diagnosis diagnosis) {
		diagnosisService.removeDiagnosis(diagnosis);
	}

	public int addPatientCase(PatientCase patientCase) {
		return patientCaseService.addPatientCase(patientCase);
	}

	public PatientCase getPatientCase() {
		return patientCase;
	}

	public void setPatientCase(int patientCaseID) {
		this.patientCase = patientCaseService.findByAttributeFirstElem("patientCaseID", patientCaseID);
	}

	public void setPatientCaseToLastPatientCase(int patientCaseID) {
		this.patientCase = patientCaseService.findLastElem("patientCaseID", patientCaseID);
	}

	public void removePatientCase(int patientCaseID) {
		patientCaseService.removePatientCase(patientCaseID);
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
		this.patientCaseList = patientCaseService.findByAttributFullDESC("patient.patientID", patientID,
				"patientCaseID");
	}

	public List<Medication> getMedicationList() {
		return medicationList;
	}

	public void setMedicationList(int patientCaseID) {
		medicationList = medicationService.findByAttributFull("patientCase.patientCaseID", patientCaseID);
	}

	public List<Diagnosis> getDiagnosisList() {
		return diagnosisList;
	}

	public void setDiagnosisList(int patientCaseID) {
		diagnosisList = diagnosisService.findByAttributFull("patientCase.patientCaseID", patientCaseID);
	}

	public void setDoctor(int doctorID) {
		this.doctor = DoctorService.findByAttributeFirstElem("doctorID", doctorID);

	}

	public Doctor getDoctor() {
		return doctor;
	}
}
