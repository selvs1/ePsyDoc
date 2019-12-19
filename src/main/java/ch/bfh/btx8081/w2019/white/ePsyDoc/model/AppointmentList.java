package ch.bfh.btx8081.w2019.white.ePsyDoc.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 * Waste of time of commenting.
 *
 * @deprecated Guys please don't use this class should be depricated due to database.
 */
public class AppointmentList {

	//todo: brauchts überhaupt diese Klasse? lg sugi

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
	
//	public void AddToAppointmentList(PatientModel patient, DateTime date) {
//		Appointment appointment = new Appointment(patient, date);
//		appointmentList.add(appointment);
//	}
	
	public void RemoveFromAppointmentList(Appointment appointment) {
		appointmentList.remove(appointment);
	}

}
