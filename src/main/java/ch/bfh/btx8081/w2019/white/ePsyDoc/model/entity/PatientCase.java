package ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity;

import javax.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
public class PatientCase {

	@Id
	@GeneratedValue
	private int patientCaseID;
	@OneToMany(mappedBy = "patientCase")
	private List<Medication> medications;
	@OneToMany(mappedBy = "patientCase")
	private List<Diagnosis> diagnosis;

	private Date date;
	@ManyToOne
	private Patient patient;
	@ManyToOne
	private Doctor doctor;


	String report;

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	public PatientCase() {

	}

	public PatientCase(int patientCaseID, Patient patient, Doctor doctor) {

		this.patient = patient;
		this.patientCaseID = patientCaseID;
		this.doctor = doctor;

	}

	public List<Medication> getMedications() {
		return medications;
	}

	public int getPatientcaseID() {
		return patientCaseID;
	}

	public void setPatientcaseID(int patientcaseID) {
		this.patientCaseID = patientcaseID;
	}

	public List<Medication> getMedicationplan() {
		return medications;
	}

	public void setMedicationplan(List<Medication> medications) {
		this.medications = medications;
	}

	public List<Diagnosis> getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(List<Diagnosis> diagnosis) {
		this.diagnosis = diagnosis;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "PatientCase [patientCaseID=" + patientCaseID + ", patientID=" + patient + ", medicationPlan="
				+ medications + ", report=" + diagnosis + ", doctor=" + doctor + "]";
	}

}