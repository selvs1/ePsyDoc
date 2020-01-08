package ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity;

import javax.persistence.*;

import java.sql.Date;
import java.util.List;

/**
 * PatientCase class with all functions.
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
@Entity
public class PatientCase {
	// Variables and database settings
	@Id
	@GeneratedValue
	private int patientCaseID;
	@OneToMany(mappedBy = "patientCase", cascade = CascadeType.REMOVE)
	private List<Medication> medications;
	@OneToMany(mappedBy = "patientCase", cascade = CascadeType.REMOVE)
	private List<Diagnosis> diagnosis;
	private Date date;
	@ManyToOne
	private Patient patient;
	@ManyToOne
	private Doctor doctor;
	String report;

	/**
	 * Empty constructor for Service class.
	 */
	public PatientCase() {
	}

	/**
	 * Constructor for patient case. Set current time.
	 * 
	 * @param patient get selected patient.
	 * @param doctor  get current doctor.
	 */
	public PatientCase(Patient patient, Doctor doctor) {
		this.patient = patient;
		this.doctor = doctor;
		this.date = new Date(System.currentTimeMillis());
		this.report = "";
	}

	/**
	 * Return report.
	 * 
	 * @return Report.
	 */
	public String getReport() {
		return report;
	}

	/**
	 * Set report.
	 * 
	 * @param report get report.
	 */
	public void setReport(String report) {
		this.report = report;
	}

	/**
	 * Return Medication.
	 * 
	 * @return Medication.
	 */
	public List<Medication> getMedications() {
		return medications;
	}

	/**
	 * Return patient case ID.
	 * 
	 * @return patientCaseID.
	 */
	public int getPatientcaseID() {
		return patientCaseID;
	}

	/**
	 * Set patient case ID.
	 * 
	 * @param patientcaseID get patient case ID.
	 */
	public void setPatientcaseID(int patientcaseID) {
		this.patientCaseID = patientcaseID;
	}

	/**
	 * Return medication list.
	 * 
	 * @return medication list.
	 */
	public List<Medication> getMedicationplan() {
		return medications;
	}

	/**
	 * Set medication list.
	 * 
	 * @param medications get medication list.
	 */
	public void setMedicationplan(List<Medication> medications) {
		this.medications = medications;
	}

	/**
	 * Return diagnosis list.
	 * 
	 * @return Diagnosis list.
	 */
	public List<Diagnosis> getDiagnosis() {
		return diagnosis;
	}

	/**
	 * Set diagnosis list.
	 * 
	 * @param diagnosis get diagnosis list.
	 */
	public void setDiagnosis(List<Diagnosis> diagnosis) {
		this.diagnosis = diagnosis;
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
	 * Set Patient.
	 * 
	 * @param patient get patient.
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
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
	 * Set doctor.
	 *
	 * @param doctor get doctor.
	 */
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	/**
	 * Return date.
	 * 
	 * @return Date.
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Set date.
	 * 
	 * @param date get date.
	 */
	public void setDate(Date date) {
		this.date = date;
	}
}