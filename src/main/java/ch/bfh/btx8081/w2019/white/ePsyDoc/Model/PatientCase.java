package ch.bfh.btx8081.w2019.white.ePsyDoc.Model;

import java.util.List;

public class PatientCase {
	private String fid;
	private List<?> reportList;
	private List<?> appointmentList;
	private MedicationPlanModel mediPlan;

	public PatientCase(String fid, List<?> reportList, List<?> appointmentList, MedicationPlanModel mediPlan) {
		this.fid = fid;
		this.reportList = reportList;
		this.appointmentList = appointmentList;
		this.mediPlan = mediPlan;
	}

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public List<?> getReportList() {
		return reportList;
	}

	public void setReportList(List<?> reportList) {
		this.reportList = reportList;
	}

	public List<?> getAppointmentList() {
		return appointmentList;
	}

	public void setAppointmentList(List<?> appointmentList) {
		this.appointmentList = appointmentList;
	}

	public MedicationPlanModel getMediPlan() {
		return mediPlan;
	}

	public void setMediPlan(MedicationPlanModel mediPlan) {
		this.mediPlan = mediPlan;
	}

}
