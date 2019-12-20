package ch.bfh.btx8081.w2019.white.ePsyDoc.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import ch.bfh.btx8081.w2019.white.ePsyDoc.database.Service;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Appointment;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.PatientCase;

public class AppointmentModel {
	private List<Appointment> appointmentList = new ArrayList<Appointment>();
	private List<PatientCase> patientCaseList = new ArrayList<PatientCase>();

	private Service<Appointment> appointmentService = new Service<>(new Appointment());
	private Service<PatientCase> patientCaseService = new Service<>(new PatientCase());

	public AppointmentModel() {
	}

	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}

	public void setAppointmentList(Date date) {
		this.appointmentList = appointmentService.getAppointmentPatient(date);
	}

	public List<PatientCase> getPatientCaseList() {
		return patientCaseList;
	}

	public void setPatientCaseList(int patientID) {
		this.patientCaseList = patientCaseService.findByAttributFullDESC("patientID", patientID,"patientCaseID");
	}
}