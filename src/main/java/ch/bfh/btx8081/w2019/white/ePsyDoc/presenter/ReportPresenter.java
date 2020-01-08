package ch.bfh.btx8081.w2019.white.ePsyDoc.presenter;

import ch.bfh.btx8081.w2019.white.ePsyDoc.model.ReportModel;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Diagnosis;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Medication;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.PatientCase;
import ch.bfh.btx8081.w2019.white.ePsyDoc.view.ReportView;

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
public class ReportPresenter implements ReportView.ReportViewListener {
	private ReportModel model;
	private ReportView view;

	/**
	 * Set model, set view and add the presenter class to the view.
	 * 
	 * @param model get model from connector.
	 * @param view  get view from connector.
	 */
	public ReportPresenter(ReportModel model, ReportView view) {
		this.model = model;
		this.view = view;
		view.addListener(this);
	}

	/**
	 * Create new patient case and update all informations.
	 * 
	 * @param patientCase get new patientCase.
	 */
	@Override
	public void addPatientCase(PatientCase patientCase) {
		int patientCaseID = model.addPatientCase(patientCase);
		model.setPatientCase(patientCaseID);
		view.setSessionID(patientCaseID);
		view.displayDoctor(model.getPatientCase());
		view.displayReport(model.getPatientCase().getReport());
		view.displayDiagnosisList(model.getDiagnosisList());
		view.displayMedicationList(model.getMedicationList());
		view.refresh();
	}

	/**
	 * Remove patient case.
	 * 
	 * @param patientCaseID get patientCaseID from current patientCase.
	 */
	@Override
	public void removePatientCase(int patientCaseID) {
		model.removePatientCase(patientCaseID);
	}

	/**
	 * Set patient case, add diagnosis and update diagnosis grid in view.
	 * 
	 * @param patientCaseID get patientCaseID from current patientCase.
	 * @param diagnosis     get new diagnosis.
	 */
	@Override
	public void addDiagnosis(int patientCaseID, Diagnosis diagnosis) {
		model.setPatientCase(patientCaseID);
		model.addDiagnosis(diagnosis);
		model.setDiagnosisList(patientCaseID);
		view.displayDiagnosisList(model.getDiagnosisList());
	}

	/**
	 * Remove diagnosis and update diagnosis grid in view.
	 * 
	 * @param patientCaseID get patientCaseID from current patientCase.
	 * @param diagnosis     get selected diagnosis.
	 */
	@Override
	public void removeDiagnosis(int patientCaseID, Diagnosis diagnosis) {
		model.removeDiagnosis(diagnosis);
		model.setDiagnosisList(patientCaseID);
		view.displayDiagnosisList(model.getDiagnosisList());
	}

	/**
	 * Set patient case and add medication. Update medication grid in view.
	 * 
	 * @param patientCaseID get patientCaseID from current patientCase.
	 * @param medication    get new medication.
	 */
	@Override
	public void addMedication(int patientCaseID, Medication medication) {
		model.setPatientCase(patientCaseID);
		model.addMedication(medication);
		model.setMedicationList(patientCaseID);
		view.displayMedicationList(model.getMedicationList());
	}

	/**
	 * Remove medication and update view with new Mmdication list.
	 * 
	 * @param patientCaseID get patientCaseID from current patientCase.
	 * @param medication    get selected medication.
	 */
	@Override
	public void removeMedication(int patientCaseID, Medication medication) {
		model.removeMedication(medication);
		model.setMedicationList(patientCaseID);
		view.displayMedicationList(model.getMedicationList());
	}

	/**
	 * Save report in patient case and set report in patient case.
	 * 
	 * @param patientCaseID get patientCaseID from current patientCase.
	 * @param report        get report of current patientCase.
	 */
	@Override
	public void saveReport(int patientCaseID, String report) {
		model.changePatientCase(patientCaseID, report);
		model.getPatientCase().setReport(report);
	}

	/**
	 * Update diagnosis grid.
	 * 
	 * @param patientCaseID get patientCaseID from current patientCase.
	 */
	@Override
	public void getDiagnosisList(int patientCaseID) {
		view.displayDiagnosisList(model.getDiagnosisList());
	}

	/**
	 * Update medication grid.
	 * 
	 * @param patientCaseID get patientCaseID from current patientCase.
	 */
	@Override
	public void getMedicationList(int patientCaseID) {
		view.displayMedicationList(model.getMedicationList());
	}

	/**
	 * Sets patientCase with the help of the patientID. Update doctor in view.
	 * 
	 * @param patientCaseID get patientCaseID from current patientCase.
	 */
	@Override
	public void getDoctor(int patientCaseID) {
		model.setPatientCase(patientCaseID);
		view.displayDoctor(model.getPatientCase());
	}

	/**
	 * Sets patientCaseList with the help of the patientID. Update the tabs in view
	 * with current patientCaseList from model.
	 * 
	 * @param patientID get patientID from current patient.
	 */
	@Override
	public void getPatientCaseList(int patientID) {
		model.setPatientCaseList(patientID);
		view.displayRegister(model.getPatientCaseList());
	}

	/**
	 * Set patientCase, patientCaseList, medicationList, sessionID with
	 * patientCaseID. Update the view. change doctor, report, medicationList,
	 * diagnosisList.
	 * 
	 * @param patientCaseID get patientCaseID from current patientCase.
	 */
	@Override
	public void getAll(int patientCaseID) {
		model.setPatientCase(patientCaseID);
		model.setDiagnosisList(patientCaseID);
		model.setMedicationList(patientCaseID);
		view.setSessionID(patientCaseID);
		view.displayDoctor(model.getPatientCase());
		view.displayReport(model.getPatientCase().getReport());
		view.displayMedicationList(model.getMedicationList());
		view.displayDiagnosisList(model.getDiagnosisList());
	}

	/**
	 * Sets patientCase with the help of the patientID. Update the grid in the view
	 * with the current PatientCaseList.
	 * 
	 * @param patientCaseID get patientCaseID from current patientCase.
	 */
	@Override
	public void getPatientCaseObject(int patientCaseID) {
		model.setPatientCase(patientCaseID);
		view.setPatientCase(model.getPatientCase());
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
}