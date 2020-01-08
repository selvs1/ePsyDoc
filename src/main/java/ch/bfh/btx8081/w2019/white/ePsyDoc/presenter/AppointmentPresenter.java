package ch.bfh.btx8081.w2019.white.ePsyDoc.presenter;

import java.sql.Date;

import ch.bfh.btx8081.w2019.white.ePsyDoc.model.AppointmentModel;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.PatientCase;
import ch.bfh.btx8081.w2019.white.ePsyDoc.view.AppointmentView;

/**
 * Connects model and view.
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
public class AppointmentPresenter implements AppointmentView.AppointmentViewListener {
	private AppointmentModel model;
	private AppointmentView view;

	/**
	 * Set model, set view and add the presenter class to the view.
	 * 
	 * @param model get model from connector.
	 * @param view  get view from connector.
	 */
	public AppointmentPresenter(AppointmentModel model, AppointmentView view) {
		this.model = model;
		this.view = view;
		view.addListener(this);
	}

	/**
	 * Set appointmentList from date in model class. Adjusts the grid of the view
	 * with the current appointmentList.
	 * 
	 * @param date get selected date from view.
	 */
	@Override
	public void loadAppointmentData(Date date) {
		model.setAppointmentList(date);
		view.displayAppointmentList(model.getAppointmentList());
	}

	/**
	 * Sets the patientCaseList for the patient with the patientID.Adjusts the grid
	 * of the view with the current patientCaseList.
	 * 
	 * @param patientID get patientID from selected patient.
	 */
	@Override
	public void setPatientCaseList(int patientID) {
		model.setPatientCaseList(patientID);
		view.displayPatientCaseList(model.getPatientCaseList());
	}

	/**
	 * Sets the selected patient using the id and returns the object to the view.
	 * 
	 * @param patientID get patientID from selected patient.
	 */
	@Override
	public void getPatientObject(int patientID) {
		model.setPatient(patientID);
		view.setPatient(model.getPatient());
	}

	/**
	 * Sets the current doctor using the id and returns the object to the view.
	 * 
	 * @param doctorID get doctorID from current doctor.
	 */
	@Override
	public void getDoctorObject(int doctorID) {
		model.setDoctor(doctorID);
		view.setDoctor(model.getDoctor());
	}

	/**
	 * Add patientCase in model and set the patientCase list with the new generated
	 * patient case. update the view grid with the new patient case list.
	 * 
	 * @param patientCase get new patientCase from view.
	 * @param patientID   get patientID from selected patient.
	 */
	@Override
	public void addPatientCase(PatientCase patientCase, int patientID) {
		model.addPatientCase(patientCase);
		model.setPatientCaseList(patientID);
		view.displayPatientCaseList(model.getPatientCaseList());
	}
}