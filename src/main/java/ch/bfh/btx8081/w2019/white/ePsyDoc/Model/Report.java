package ch.bfh.btx8081.w2019.white.ePsyDoc.Model;


public class Report {
	 
	private Doctor doctor;
	private PatientModel patient;
	private String report;
	private DiagnosisList diagnoseList;
	
	
	public Report(Doctor doctor, PatientModel patient) {
		this.doctor = doctor;
		this.patient = patient;
		this.report = null;
		this.diagnoseList = null;
	}

}
