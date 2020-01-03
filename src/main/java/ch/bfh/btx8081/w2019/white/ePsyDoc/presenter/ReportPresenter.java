package ch.bfh.btx8081.w2019.white.ePsyDoc.presenter;

import java.util.List;

import ch.bfh.btx8081.w2019.white.ePsyDoc.model.ReportModel;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Diagnosis;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Doctor;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Medication;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Patient;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.PatientCase;
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
	public void addPatientCase(PatientCase patientCase) {
		int patientCaseID = model.addPatientCase(patientCase);
		model.setPatientCase(patientCaseID);
		view.updateAll(model.getPatientCaseList(),model.getPatientCase(),model.getDiagnosisList(),model.getMedicationList());
		view.refresh();
	}

	@Override
	public void removePatientCase(int patientCaseID) {
		model.removePatientCase(patientCaseID);
	}

	@Override
	public void addDiagnosis(int patientCaseID, Diagnosis diagnosis) {
		model.setPatientCase(patientCaseID);
		model.addDiagnosis(diagnosis);
		model.setDiagnosisList(patientCaseID);
		view.displayDiagnosisList(model.getDiagnosisList());
		
	}

	@Override
	public void removeDiagnosis(int patientCaseID, Diagnosis diagnosis) {
		model.removeDiagnosis(diagnosis);
		model.setDiagnosisList(patientCaseID);
		view.displayDiagnosisList(model.getDiagnosisList());	
	}

	@Override
	public void addMedication(int patientCaseID,Medication medication) {
		model.setPatientCase(patientCaseID);
		model.addMedication(medication);
		model.setMedicationList(patientCaseID);
		view.displayMedicationList(model.getMedicationList());
		
	}

	@Override
	public void removeMedication(int patientCaseID,Medication medication) {
		model.removeMedication(medication);
		model.setMedicationList(patientCaseID);
		view.displayMedicationList(model.getMedicationList());
		
	}

	@Override
	public void saveReport(int patientCaseID, String report) {
		model.changePatientCase(patientCaseID, report);
	}

	@Override
	public void getDiagnosisList(int patientCaseID) {
		view.displayDiagnosisList(model.getDiagnosisList());
		
	}

	@Override
	public void getMedicationList(int patientCaseID) {
		view.displayMedicationList(model.getMedicationList());
		
	}

	@Override
	public void getPatientCase(int patientCaseID) {
		model.setPatientCase(patientCaseID);
		view.displayRegister(model.getPatientCaseList());
		
	}

	@Override
	public void getDoctor(int patientCaseID) {
		model.setPatientCase(patientCaseID);
		view.displayDoctor(model.getPatientCase());
		
	}

	@Override
	public void getPatientCaseList(int patientID) {
		model.setPatientCaseList(patientID);
		view.displayRegister(model.getPatientCaseList());
		
	}

	@Override
	public void getAll(int patientCaseID, int patientID) {
		model.setPatientCase(patientCaseID);
		model.setPatientCaseList(patientID);
		model.setDiagnosisList(patientCaseID);
		model.setMedicationList(patientCaseID);
		
		PatientCase patientCase = model.getPatientCase();
		List<PatientCase> patientCaseList = model.getPatientCaseList();
		List<Diagnosis> diagnosis = model.getDiagnosisList();
		List<Medication> medication = model.getMedicationList();

		view.updateAll(patientCaseList, patientCase, diagnosis, medication);
	}

	@Override
	public void getPatientCaseObject(int patientCaseID) {
		model.setPatientCase(patientCaseID);
		view.setPatientCase(model.getPatientCase());
		
	}

	@Override
	public void getDoctorObject(int doctorID) {
		model.setDoctor(doctorID);
		view.setDoctor(model.getDoctor());
	}

}
