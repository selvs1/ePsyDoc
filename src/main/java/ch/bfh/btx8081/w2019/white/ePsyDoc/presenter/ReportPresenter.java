package ch.bfh.btx8081.w2019.white.ePsyDoc.presenter;

import ch.bfh.btx8081.w2019.white.ePsyDoc.model.ReportModel;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Diagnosis;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Medication;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.PatientCase;
import ch.bfh.btx8081.w2019.white.ePsyDoc.view.ReportView;

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
public class ReportPresenter implements ReportView.ReportViewListener {
	private ReportModel model;
	private ReportView view;

	/**
	 * 
	 * @param model
	 * @param view
	 */
	public ReportPresenter(ReportModel model, ReportView view) {
		this.model = model;
		this.view = view;
		view.addListener(this);
	}

	/**
	 * @param patientCase
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
	 * @param patientCaseID
	 */
	@Override
	public void removePatientCase(int patientCaseID) {
		model.removePatientCase(patientCaseID);
	}

	/**
	 * @param patientCaseID
	 * @param diagnosis
	 */
	@Override
	public void addDiagnosis(int patientCaseID, Diagnosis diagnosis) {
		model.setPatientCase(patientCaseID);
		model.addDiagnosis(diagnosis);
		model.setDiagnosisList(patientCaseID);
		view.displayDiagnosisList(model.getDiagnosisList());
	}

	/**
	 * @param patientCaseID
	 * @param diagnosis
	 */
	@Override
	public void removeDiagnosis(int patientCaseID, Diagnosis diagnosis) {
		model.removeDiagnosis(diagnosis);
		model.setDiagnosisList(patientCaseID);
		view.displayDiagnosisList(model.getDiagnosisList());
	}

	/**
	 * @param patientCaseID
	 * @param medication
	 */
	@Override
	public void addMedication(int patientCaseID, Medication medication) {
		model.setPatientCase(patientCaseID);
		model.addMedication(medication);
		model.setMedicationList(patientCaseID);
		view.displayMedicationList(model.getMedicationList());
	}

	/**
	 * @param patientCaseID
	 * @param medication
	 */
	@Override
	public void removeMedication(int patientCaseID, Medication medication) {
		model.removeMedication(medication);
		model.setMedicationList(patientCaseID);
		view.displayMedicationList(model.getMedicationList());
	}

	/**
	 * @param patientCaseID
	 * @param report
	 */
	@Override
	public void saveReport(int patientCaseID, String report) {
		model.changePatientCase(patientCaseID, report);
		model.getPatientCase().setReport(report);
	}

	/**
	 * @param patientCaseID
	 */
	@Override
	public void getDiagnosisList(int patientCaseID) {
		view.displayDiagnosisList(model.getDiagnosisList());
	}

	/**
	 * @param patientCaseID
	 */
	@Override
	public void getMedicationList(int patientCaseID) {
		view.displayMedicationList(model.getMedicationList());
	}

	/**
	 * @param patientCaseID
	 */
	@Override
	public void getPatientCase(int patientCaseID) {
		model.setPatientCase(patientCaseID);
		view.displayRegister(model.getPatientCaseList());
	}

	/**
	 * @param patientCaseID
	 */
	@Override
	public void getDoctor(int patientCaseID) {
		model.setPatientCase(patientCaseID);
		view.displayDoctor(model.getPatientCase());
	}

	/**
	 * @param patientID
	 */
	@Override
	public void getPatientCaseList(int patientID) {
		model.setPatientCaseList(patientID);
		view.displayRegister(model.getPatientCaseList());
	}

	/**
	 * @param patientCaseID
	 * @param patientID
	 */
	@Override
	public void getAll(int patientCaseID, int patientID) {
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
	 * @param patientCaseID
	 */
	@Override
	public void getPatientCaseObject(int patientCaseID) {
		model.setPatientCase(patientCaseID);
		view.setPatientCase(model.getPatientCase());
	}

	/**
	 * @param doctorID
	 */
	@Override
	public void getDoctorObject(int doctorID) {
		model.setDoctor(doctorID);
		view.setDoctor(model.getDoctor());
	}
}