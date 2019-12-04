package ch.bfh.btx8081.w2019.white.ePsyDoc.Model;

import java.util.ArrayList;

public class PatientCase {

	private int patientCaseID;
	private int patientID;
	private MedicationPlan medicationPlan;
	private Report report;
	private Doctor doctor;

	public PatientCase(int patientCaseID, int patientID) {
		
		this.patientID = patientID;
		this.patientCaseID = patientCaseID;
		this.medicationPlan = new MedicationPlan(patientID, patientID);

	}

	public MedicationPlan getMedicationPlan() {
		return medicationPlan;
	}

	public void addToMedicationPlan(Medication medication) {
		medicationPlan.addToMedicationplan(medication);
	}

	public void RemoveFromMedicationPlan(String brandname) {
		medicationPlan.removeFromMedicationplan(brandname);
	}

	public int getPatientcaseID() {
		return patientCaseID;
	}

	public void setPatientcaseID(int patientcaseID) {
		this.patientCaseID = patientcaseID;
	}

	public int getPatientID() {
		return patientID;
	}

	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}

	public MedicationPlan getMedicationplan() {
		return medicationPlan;
	}

	public void setMedicationplan(MedicationPlan medicationplan) {
		this.medicationPlan = medicationplan;
	}

	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

}
