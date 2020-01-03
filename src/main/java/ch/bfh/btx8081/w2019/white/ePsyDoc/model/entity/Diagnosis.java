package ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Diagnosis {
	@Id
	@GeneratedValue
	private int diagnosisID;

	@ManyToOne
	private PatientCase patientCase;

	private String diagnosis;
	
	public Diagnosis() {
		
	}
	
	public Diagnosis(PatientCase patientCase,String diagnosis){
		this.patientCase=patientCase;
	this.diagnosis = diagnosis;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	
	@Override
	public String toString() {
	return diagnosis;
	}

	public int getDiagnosisID() {
		return diagnosisID;
	}

	public void setDiagnosisID(int diagnosisID) {
		this.diagnosisID = diagnosisID;
	}

	public PatientCase getPatientCase() {
		return patientCase;
	}

	public void setPatientCase(PatientCase patientCase) {
		this.patientCase = patientCase;
	}
}
