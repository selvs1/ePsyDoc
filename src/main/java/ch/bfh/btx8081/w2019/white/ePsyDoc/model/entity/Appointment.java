package ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

/**
 * Appointment class with all functions.
 * 
 * @author Alain Nippel
 * @author Apiwat-David Gaupp
 * @author Janahan Sellathurai
 * @author Marko Miletic
 * @author Sugeelan Selvasingham
 * @author Viktor Velkov
 * 
 * @version 1.0
 */
@Entity
public class Appointment {
	// Variables and database settings
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int appointmentID;
	@ManyToOne
	private Doctor doctor;
	@ManyToOne
	private Patient patient;
	Date appointmentDate;
	Time appointmentTime;

	/**
	 * Empty constructor for Service class.
	 */
	public Appointment() {
	}

	/**
	 * Returns appointmentID.
	 * 
	 * @return AppointmentID.
	 */
	public int getAppointmentID() {
		return appointmentID;
	}

	/**
	 * Set appointment ID.
	 * 
	 * @param AppointmentID get appointmentID.
	 */
	public void setAppointmentID(int appointmentID) {
		this.appointmentID = appointmentID;
	}

	/**
	 * Return doctor.
	 * 
	 * @return Doctor.
	 */
	public Doctor getDoctor() {
		return doctor;
	}

	/**
	 * Set doctor.
	 * 
	 * @param doctor get doctor.
	 */
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	/**
	 * Return patient.
	 * 
	 * @return Patient.
	 */
	public Patient getPatient() {
		return patient;
	}

	/**
	 * Set Patient.
	 * 
	 * @param patient get Patient.
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	/**
	 * Return appointment time.
	 * 
	 * @return AppointmentTime.
	 */
	public Time getAppointmentTime() {
		return appointmentTime;
	}

	/**
	 * set appointment time.
	 * 
	 * @param appointmentTime get time of appointment.
	 */
	public void setAppointmentTime(Time appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	/**
	 * Return patient last name.
	 * 
	 * @return Patient last name.
	 */
	public String getPatientLastname() {
		return patient.getLastname();
	}

	/**
	 * Return patient first name.
	 * 
	 * @return patient first name.
	 */
	public String getPatientFirstname() {
		return patient.getFirstname();
	}

	/**
	 * Return date of appointment.
	 * 
	 * @return appointment date.
	 */
	public Date getAppointmentDate() {
		return appointmentDate;
	}

	/**
	 * set appointment date.
	 * 
	 * @param appointmentDate get date of appointment.
	 */
	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

}