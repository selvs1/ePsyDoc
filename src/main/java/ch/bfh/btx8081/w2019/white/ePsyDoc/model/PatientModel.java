package ch.bfh.btx8081.w2019.white.ePsyDoc.model;

import java.util.ArrayList;
import java.util.List;

import ch.bfh.btx8081.w2019.white.ePsyDoc.model.database.Service;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Doctor;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Patient;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.PatientCase;

/**
 * Model of Patient. Connect to database.
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
public class PatientModel {
	private List<Patient> patientList = new ArrayList<Patient>();
	private List<PatientCase> patientCaseList = new ArrayList<PatientCase>();
	private Service<Patient> patientService = new Service<>(new Patient());
	private Service<PatientCase> patientCaseService = new Service<>(new PatientCase());
	private Service<Doctor> DoctorService = new Service<>(new Doctor());
	private Patient patient;
	private Doctor doctor;

	/**
	 * Empty constructor.
	 */
	public PatientModel() {
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
	 * Set patient list.
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
	 * Set patient Case list with patient ID.
	 * 
	 * @param patientID get patient ID.
	 */
	public void setPatientCaseList(int patientID) {
		this.patientCaseList = patientCaseService.findByAttributFullDESC("patient.patientID", patientID,
				"patientCaseID");
	}

	/**
	 * Method that is executed at the beginning.
	 */
	public void init() {
		setPatientList(patientService.getEntityTable());
	}

	/**
	 * Set doctor with doctor ID.
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

	/**
	 * Set patient with patient ID.
	 * 
	 * @param patientID get patient ID.
	 */
	public void setPatient(int patientID) {
		patient = patientService.findByAttributeFirstElem("patientID", patientID);
	}

	/**
	 * Return patient.
	 * 
	 * @return Patient.
	 */
	public Patient getPatient() {
		return patient;
	}

	/**
	 * Add patient case.
	 * 
	 * @param patientCase get patient case.
	 * @return ID form new generated patient case.
	 */
	public int addPatientCase(PatientCase patientCase) {
		return patientCaseService.addPatientCase(patientCase);
	}
}