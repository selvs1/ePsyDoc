package ch.bfh.btx8081.w2019.white.ePsyDoc.model;

import org.eclipse.persistence.jpa.jpql.parser.DateTime;

public class Appointment {
	PatientModel patient;
	DateTime date;
	
	public Appointment(PatientModel patient, DateTime date) {
		this.patient = patient;
		this.date = date;
	}

}
