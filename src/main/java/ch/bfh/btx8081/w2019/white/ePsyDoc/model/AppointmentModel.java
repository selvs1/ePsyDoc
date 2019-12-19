package ch.bfh.btx8081.w2019.white.ePsyDoc.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import ch.bfh.btx8081.w2019.white.ePsyDoc.database.Service;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Appointment;

public class AppointmentModel {
	private List<Appointment> appointmentList = new ArrayList<Appointment>();

	private Service<Appointment> appointmentService = new Service<>(new Appointment());

	public AppointmentModel() {

	}

	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}

	public void setAppointmentList(List<Appointment> appointmentList) {
		this.appointmentList = appointmentList;
	}

	public void init() {
		//Probleme mit Datentyp date
		setAppointmentList(appointmentService.findByAttributFull("appointmentDate",(Date) new Date(System.currentTimeMillis())));

	}

}
