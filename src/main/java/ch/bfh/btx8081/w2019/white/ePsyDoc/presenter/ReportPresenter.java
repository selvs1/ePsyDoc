package ch.bfh.btx8081.w2019.white.ePsyDoc.presenter;

import ch.bfh.btx8081.w2019.white.ePsyDoc.model.ReportModel;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Diagnosis;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Doctor;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Medication;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Patient;
import ch.bfh.btx8081.w2019.white.ePsyDoc.view.ReportView;

public class ReportPresenter implements ReportView.ReportViewListener {
	private ReportModel model;
	private ReportView view;

	public ReportPresenter(ReportModel model, ReportView view) {
		this.model = model;
		this.view = view;
		view.addListener(this);
	}

	@Override
	public void createPatientCase(Patient patient, Doctor doctor) {
		model.addPatientCase(patient, doctor);
		view.updateAll(model.getPatientCaseList(),model.getDiagnosisList(),model.getMedicationList());
	}

	@Override
	public void removePatientCase(int patientCaseID) {
		model.removePatientCase(patientCaseID);
		view.updateAll(model.getPatientCaseList(),model.getDiagnosisList(),model.getMedicationList());
	}

	@Override
	public void createDiagnosis(Diagnosis diagnosis) {
		model.addDiagnosis(diagnosis);
		view.displayDiagnosisList(model.getDiagnosisList());
		
	}

	@Override
	public void removeDiagnosis(int diagnosisID) {
		model.removeDiagnosis(diagnosisID);
		view.displayDiagnosisList(model.getDiagnosisList());	
	}

	@Override
	public void createMedication(Medication medication) {
		model.addMedication(medication);
		view.displayMedicationList(model.getMedicationList());
		
	}

	@Override
	public void removeMedication(int medicationID) {
		model.removeMedication(medicationID);
		view.displayMedicationList(model.getMedicationList());
		
	}

	@Override
	public void save(int patientCaseID, String consultation) {
		model.changePatientCase(patientCaseID, consultation);
	}

	@Override
	public void getDiagnosisList() {
		view.displayDiagnosisList(model.getDiagnosisList());
		
	}

	@Override
	public void getMedicationList() {
		view.displayMedicationList(model.getMedicationList());
		
	}

	@Override
	public void getPatientCase() {
		view.displayRegister(model.getPatientCaseList());
		
	}

}
