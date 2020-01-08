package ch.bfh.btx8081.w2019.white.ePsyDoc.presenter;

import ch.bfh.btx8081.w2019.white.ePsyDoc.model.PatientModel;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.PatientCase;
import ch.bfh.btx8081.w2019.white.ePsyDoc.view.PatientView;

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
public class PatientPresenter implements PatientView.PatientViewListener {
	private PatientModel model;
	private PatientView view;

	/**
	 * Set model, set view and add the presenter class to the view.
	 * 
	 * @param model get model from connector.
	 * @param view  get view from connector.
	 */
	public PatientPresenter(PatientModel model, PatientView view) {
		this.model = model;
		this.view = view;
		view.addListener(this);
	}

	/**
	 * Get patientList and display the list in the view.
	 */
	@Override
	public void loadPatientList() {
		view.displayPatientList(model.getPatientList());
	}

	/**
	 * Sets the patientCaseList for the patient with the patientID.Adjusts the grid
	 * of the view with the current patientCaseList.
	 * 
	 * @param patient ID get selected patient.
	 */
	@Override
	public void setPatientCaseList(int patientID) {
		model.setPatientCaseList(patientID);
		view.displayPatientCaseList(model.getPatientCaseList());
	}

	/**
	 * Get patientList and update the patient grid in the view.
	 */
	@Override
	public void loadPatientCaseList() {
		view.displayPatientList(model.getPatientList());
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