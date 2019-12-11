package ch.bfh.btx8081.w2019.white.ePsyDoc.model;

import ch.bfh.btx8081.w2019.white.ePsyDoc.entity.Doctor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PatientCase {

	@Id
	@GeneratedValue
	private int hospitalPatientCaseID;

	@OneToOne(mappedBy = "patientCase")
	private Appointment appointment;
	@OneToOne(mappedBy = "patientCase")
	private MedicationPlan medicationPlan;
	@OneToOne(mappedBy = "patientCase")
	private Report report;


//	todo: 10.12.2019 Why string?? - lg sugi
	private String patientCaseID;
	private int patientID;


	private Doctor doctor;




	public PatientCase() {

	}

	public PatientCase(String patientCaseID, int patientID) {
		this.patientID = patientID;
		this.patientCaseID = patientCaseID;
		this.medicationPlan = new MedicationPlan();
		this.report = new Report();

	}

	public MedicationPlan getMedicationPlan() {
		return medicationPlan;
	}

	public String getPatientcaseID() {
		return patientCaseID;
	}

	public void setPatientcaseID(String patientcaseID) {
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

	@Override
	public String toString() {
		return "PatientCase [patientCaseID=" + patientCaseID + ", patientID=" + patientID + ", medicationPlan="
				+ medicationPlan + ", report=" + report + ", doctor=" + doctor + "]";
	}

}
