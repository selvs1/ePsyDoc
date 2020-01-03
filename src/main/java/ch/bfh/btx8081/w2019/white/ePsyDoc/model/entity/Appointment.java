package ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
public class Appointment {
    @Id
    @GeneratedValue
    int appointmentID;

    @ManyToOne
    private Doctor doctor;
    @ManyToOne
    private Patient patient;

    Date appointmentDate;
    Time appointmentTime;

	public Appointment() {
    }

    public Appointment(Patient patient, Date date) {
        this.patient = patient;
        this.appointmentDate = date;
    }

    public int getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }
    public Time getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(Time appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    public String getPatientLastname() {
    	return patient.getLastname();
    }
    public String getPatientFirstname() {
    	return patient.getFirstname();
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
    
}