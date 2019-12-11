package ch.bfh.btx8081.w2019.white.ePsyDoc.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Report {

	@Id
	@GeneratedValue
	private int reportID;

	@OneToOne(mappedBy = "report")
	private PatientCase patientCase;
	@ManyToMany
	private List<Diagnosis> diagnoses = new ArrayList<>();



	private int DoctorID;
	private String report;
	private DiagnosisList diagnosisList;
	
	public Report() {
		this.report = null;
		diagnosisList = new DiagnosisList();
	}

	public int getDoctorID() {
		return DoctorID;
	}

	public void setDoctorID(int doctorID) {
		DoctorID = doctorID;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	public DiagnosisList getDiagnosisList() {
		return diagnosisList;
	}

	public void setDiagnosisList(DiagnosisList diagnosisList) {
		this.diagnosisList = diagnosisList;
	}

}

