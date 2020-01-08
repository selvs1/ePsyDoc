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

	/**
	 * Save report in patient case.
	 * 
	 * @param patientCaseID get patient case ID.
	 * @param report        get changed report.
	 */
	public void changePatientCase(int patientCaseID, String report) {
		patientCaseService.updatePatientCaseReport(patientCaseID, report);
	}

	/**
	 * Add medication.
	 * 
	 * @param medication get new medication.
	 */
	public void addMedication(Medication medication) {
		medicationService.addMedication(medication);
	}

	/**
	 * Remove medication.
	 * 
	 * @param medication get selected medication.
	 */
	public void removeMedication(Medication medication) {
		medicationService.removeMedication(medication);
	}

	/**
	 * Add diagnosis.
	 * 
	 * @param diagnosis get new diagnosis.
	 */
	public void addDiagnosis(Diagnosis diagnosis) {
		diagnosisService.addDiagnosis(diagnosis);
	}

	/**
	 * remove Diagnosis.
	 * 
	 * @param diagnosis get selected diagnosis.
	 */
	public void removeDiagnosis(Diagnosis diagnosis) {
		diagnosisService.removeDiagnosis(diagnosis);
	}

	/**
	 * Create patient case.
	 * 
	 * @param patientCase get patient case.
	 * @return id of created patient case.
	 */
	public int addPatientCase(PatientCase patientCase) {
		return patientCaseService.addPatientCase(patientCase);
	}

	/**
	 * Return patient case.
	 * 
	 * @return Patient case.
	 */
	public PatientCase getPatientCase() {
		return patientCase;
	}

	/**
	 * Set Patient Case with patient case ID.
	 * 
	 * @param patientCaseID get patient case ID:
	 */
	public void setPatientCase(int patientCaseID) {
		this.patientCase = patientCaseService.findByAttributeFirstElem("patientCaseID", patientCaseID);
	}

	/**
	 * Remove patient case with patient case ID.
	 * 
	 * @param patientCaseID get patient case ID.
	 */
	public void removePatientCase(int patientCaseID) {
		patientCaseService.removePatientCase(patientCaseID);
	}

	/**
	 * Return patient list.
	 * 
	 * @return Patient list.
	 */
	public List<Patient> getPatientList() {
		return patientList;
	}

	/**
	 * Set Patient List.
	 * 
	 * @param patientList get patient list.
	 */
	public void setPatientList(List<Patient> patientList) {
		this.patientList = patientList;
	}

	/**
	 * Return patient case list.
	 * 
	 * @return Patient case list.
	 */
	public List<PatientCase> getPatientCaseList() {
		return patientCaseList;
	}

	/**
	 * Set Patient case list with patient ID.
	 * 
	 * @param patientID get patient ID.
	 */
	public void setPatientCaseList(int patientID) {
		this.patientCaseList = patientCaseService.findByAttributFullDESC("patient.patientID", patientID,
				"patientCaseID");
	}

	/**
	 * Return medication list.
	 * 
	 * @return Medication list.
	 */
	public List<Medication> getMedicationList() {
		return medicationList;
	}

	/**
	 * Set medication list.
	 * 
	 * @param patientCaseID get patient case ID.
	 */
	public void setMedicationList(int patientCaseID) {
		medicationList = medicationService.findByAttributFull("patientCase.patientCaseID", patientCaseID);
	}

	/**
	 * Return diagnosis list.
	 * 
	 * @return diagnosis list.
	 */
	public List<Diagnosis> getDiagnosisList() {
		return diagnosisList;
	}

	/**
	 * Set diagnose list with patient case ID.
	 * 
	 * @param patientCaseID get patient case ID.
	 */
	public void setDiagnosisList(int patientCaseID) {
		diagnosisList = diagnosisService.findByAttributFull("patientCase.patientCaseID", patientCaseID);
	}

	/**
	 * Set doctor from doctor service.
	 * 
	 * @param doctorID get doctor ID.
	 */
	public void setDoctor(int doctorID) {
		this.doctor = DoctorService.findByAttributeFirstElem("doctorID", doctorID);

	}

	/**
	 * Return doctor.
	 * 
	 * @return Doctor.
	 */
	public Doctor getDoctor() {
		return doctor;
	}
}
