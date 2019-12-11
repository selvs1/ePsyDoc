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

	public int getReportID() {
		return reportID;
	}

	public void setReportID(int reportID) {
		this.reportID = reportID;
	}

	public PatientCase getPatientCase() {
		return patientCase;
	}

	public void setPatientCase(PatientCase patientCase) {
		this.patientCase = patientCase;
	}

	public List<Diagnosis> getDiagnosisList() {
		return diagnoses;
	}


	public void setDiagnoses(List<Diagnosis> diagnoses) {
		this.diagnoses = diagnoses;
	}

	private int doctorID;
	private String report;
//	private DiagnosisList diagnosisList; todo: sugi bestätig durch jena
	
	public Report() {
		this.report = null;
//		diagnosisList = new DiagnosisList();
	}

	public int getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

//	public DiagnosisList getDiagnosisList() {
//		return diagnosisList;
//	}

//	public void setDiagnosisList(DiagnosisList diagnosisList) {
//		this.diagnosisList = diagnosisList;
//	}

}

