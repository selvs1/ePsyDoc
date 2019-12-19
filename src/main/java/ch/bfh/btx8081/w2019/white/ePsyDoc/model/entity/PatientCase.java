package ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity;

import javax.persistence.*;

@Entity
public class PatientCase {

	@Id
	@GeneratedValue
	private int patientCaseID;
	/* not used
	@OneToOne(mappedBy = "patientCase")
	private Appointment appointment;
	*/
	@OneToOne
	private MedicationPlan medicationPlan;
	@OneToOne
	private Report report;

	//todo: PatientCase noch mit Patienten und Doctor verknüpfen
	@ManyToOne
	private Patient patient;
	@ManyToOne
	private Doctor doctor;


//	todo: 10.12.2019 Why string?? - lg sugi
	private int patientID;






	public PatientCase() {

	}

	public PatientCase(int patientCaseID, int patientID) {
		this.patientID = patientID;
		this.patientCaseID = patientCaseID;
		this.medicationPlan = new MedicationPlan();
		this.report = new Report();

	}

	public MedicationPlan getMedicationPlan() {
		return medicationPlan;
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

	@Override
	public String toString() {
		return "PatientCase [patientCaseID=" + patientCaseID + ", patientID=" + patientID + ", medicationPlan="
				+ medicationPlan + ", report=" + report + ", doctor=" + doctor + "]";
	}

}
