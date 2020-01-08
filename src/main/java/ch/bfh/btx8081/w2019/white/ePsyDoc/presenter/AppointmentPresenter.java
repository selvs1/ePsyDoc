package ch.bfh.btx8081.w2019.white.ePsyDoc.presenter;

import java.sql.Date;

import ch.bfh.btx8081.w2019.white.ePsyDoc.model.AppointmentModel;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.PatientCase;
import ch.bfh.btx8081.w2019.white.ePsyDoc.view.AppointmentView;

/**
 * @author Alain Nippel
 * @author Apiwat-David Gaupp
 * @author Janahan Sellathurai
 * @author Marko Miletic
 * @author Sugeelan Selvasingham
 * @author Viktor Velkov
 * 
 * @version 1.0
 * 
 *          connects model and view.
 */
public class AppointmentPresenter implements AppointmentView.AppointmentViewListener {
	private AppointmentModel model;
	private AppointmentView view;

	/**
	 * 
	 * @param model
	 * @param view
	 */
	public AppointmentPresenter(AppointmentModel model, AppointmentView view) {
		this.model = model;
		this.view = view;
		view.addListener(this);
	}

	/**
	 * @param date
	 */
	@Override
	public void loadAppointmentData(Date date) {
		model.setAppointmentList(date);
		view.displayAppointmentList(model.getAppointmentList());
	}

	/**
	 * @param patientID
	 */
	@Override
	public void setPatientCaseList(int patientID) {
		model.setPatientCaseList(patientID);
		view.displayPatientCaseList(model.getPatientCaseList());
	}

	/**
	 * @param patientID
	 */
	@Override
	public void getPatientObject(int patientID) {
		model.setPatient(patientID);
		view.setPatient(model.getPatient());
	}

	/**
	 * @param doctorID
	 */
	@Override
	public void getDoctorObject(int doctorID) {
		model.setDoctor(doctorID);
		view.setDoctor(model.getDoctor());
	}

	/**
	 * @param patientCase
	 * @param patientID
	 */
	@Override
	public void addPatientCase(PatientCase patientCase, int patientID) {
		model.addPatientCase(patientCase);
		model.setPatientCaseList(patientID);
		view.displayPatientCaseList(model.getPatientCaseList());
	}
}