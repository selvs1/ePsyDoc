package ch.bfh.btx8081.w2019.white.ePsyDoc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Diagnosis {
	@Id
	@GeneratedValue
	private int diagnosisID;

	@ManyToMany(mappedBy = "diagnoses")
	private List<Report> reports = new ArrayList<>();

	private String diagnosis;

	public Diagnosis() {

	}

	
	public Diagnosis(String diagnosis){
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

	public List<Report> getReports() {
		return reports;
	}

	public void setReports(List<Report> reports) {
		this.reports = reports;
	}
}
