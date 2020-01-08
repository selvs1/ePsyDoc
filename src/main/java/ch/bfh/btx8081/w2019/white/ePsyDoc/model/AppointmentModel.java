package ch.bfh.btx8081.w2019.white.ePsyDoc.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import ch.bfh.btx8081.w2019.white.ePsyDoc.database.Service;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Appointment;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Doctor;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Patient;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.PatientCase;

/**
 * Model of Appointment. Connect to database.
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
public class AppointmentModel {
	private List<Appointment> appointmentList = new ArrayList<Appointment>();
	private List<PatientCase> patientCaseList = new ArrayList<PatientCase>();

	private Service<Appointment> appointmentService = new Service<>(new Appointment());
	private Service<PatientCase> patientCaseService = new Service<>(new PatientCase());
	private Service<Patient> patientService = new Service<>(new Patient());
	private Service<Doctor> DoctorService = new Service<>(new Doctor());
	private PatientCase patientCase;
	private Doctor doctor;
	private Patient patient;

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
		this.patientCaseList = patientCaseService.findByAttributFullDESC("patient.patientID", patientID,
				"patientCaseID");
	}

	public void setDoctor(int doctorID) {
		this.doctor = DoctorService.findByAttributeFirstElem("doctorID", doctorID);
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public PatientCase getPatientCase() {
		return patientCase;
	}

	public void setPatient(int patientID) {
		patient = patientService.findByAttributeFirstElem("patientID", patientID);
	}

	public Patient getPatient() {
		return patient;
	}

	public int addPatientCase(PatientCase patientCase) {
		return patientCaseService.addPatientCase(patientCase);
	}
}