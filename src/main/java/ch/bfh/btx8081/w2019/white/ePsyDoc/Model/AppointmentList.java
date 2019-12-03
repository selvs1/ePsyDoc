package ch.bfh.btx8081.w2019.white.ePsyDoc.Model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.persistence.jpa.jpql.parser.DateTime;

public class AppointmentList {
	
	List<Appointment> appointmentList;
	
	public AppointmentList() {
		appointmentList = new ArrayList<Appointment>();
	}

	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}

	public void setAppointmentList(List<Appointment> appointmentList) {
		this.appointmentList = appointmentList;
	}
	
	public void AddToAppointmentList(PatientModel patient, DateTime date) {
		Appointment appointment = new Appointment(patient, date);
		appointmentList.add(appointment);
	}
	
	public void RemoveFromAppointmentList(Appointment appointment) {
		appointmentList.remove(appointment);
	}

}
