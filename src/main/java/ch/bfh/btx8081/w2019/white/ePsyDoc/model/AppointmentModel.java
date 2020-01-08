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

	/**
	 * Empty constructor.
	 */
	public AppointmentModel() {
	}

	/**
	 * Return appointment list.
	 * 
	 * @return appointment list.
	 */
	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}

	/**
	 * Set appointment date in Service.
	 * 
	 * @param date get date from presenter.
	 */
	public void setAppointmentList(Date date) {
		this.appointmentList = appointmentService.getAppointmentPatient(date);
	}

	/**
	 * Return patient case list.
	 * 
	 * @return Patient case list.
	 */
	public List<PatientCase> getPatientCaseList() {
		return patientCaseList;
	}

	/**
	 * Set patient case list and sort DESC.
	 * 
	 * @param patientID get patient ID from presenter.
	 */
	public void setPatientCaseList(int patientID) {
		this.patientCaseList = patientCaseService.findByAttributFullDESC("patient.patientID", patientID,
				"patientCaseID");
	}

	/**
	 * Set doctor from doctor service.
	 * 
	 * @param doctorID get doctor ID.
	 */
	public void setDoctor(int doctorID) {
		this.doctor = DoctorService.findByAttributeFirstElem("doctorID", doctorID);
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
	 * Return patient case.
	 * 
	 * @return Patient case.
	 */
	public PatientCase getPatientCase() {
		return patientCase;
	}

	/**
	 * Set Patient from patient service.
	 * 
	 * @param patientID get patient ID from presenter.
	 */
	public void setPatient(int patientID) {
		patient = patientService.findByAttributeFirstElem("patientID", patientID);
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
	 * Add patient case.
	 * 
	 * @param patientCase get patient case from presenter.
	 * @return New patient case ID.
	 */
	public int addPatientCase(PatientCase patientCase) {
		return patientCaseService.addPatientCase(patientCase);
	}
}