package ch.bfh.btx8081.w2019.white.ePsyDoc.Model;

import java.util.List;

public class PatientCase {
	private String FID;
	private List reportList;
	private List appointmentList;
	private MedicationPlan mediPlan;
	public String getFID() {
		return FID;
	}
	public void setFID(String fID) {
		FID = fID;
	}
	public List getReportList() {
		return reportList;
	}
	public void setReportList(List reportList) {
		this.reportList = reportList;
	}
	public List getAppointmentList() {
		return appointmentList;
	}
	public void setAppointmentList(List appointmentList) {
		this.appointmentList = appointmentList;
	}
	public MedicationPlan getMediPlan() {
		return mediPlan;
	}
	public void setMediPlan(MedicationPlan mediPlan) {
		this.mediPlan = mediPlan;
	}
	
}
