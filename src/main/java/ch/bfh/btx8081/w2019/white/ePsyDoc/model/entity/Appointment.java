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

   /* not used
    * @OneToOne
    private PatientCase patientCase;
*/
    Date appointmentDate;
    Time appointmentTime;

//	todo: auskommentiert, lg sugi
//	PatientModel patient;
//	DateTime date;



	public Appointment() {

    }

    public Appointment(Patient patient, Date date) {
        this.patient = patient;
        this.appointmentDate = date;
    }


// todo: 10.12.2019 - lg sugi
//	public Appointment(PatientModel patient, DateTime date) {
//		this.patient = patient;
//		this.date = date;
//	}


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

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
}
