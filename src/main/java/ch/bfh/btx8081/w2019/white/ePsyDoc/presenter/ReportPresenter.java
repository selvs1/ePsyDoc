package ch.bfh.btx8081.w2019.white.ePsyDoc.presenter;

import com.vaadin.flow.server.VaadinSession;

import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Diagnosis;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Medication;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.MedicationPlan;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Patient;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.PatientCase;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.PatientModel;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Report;
import ch.bfh.btx8081.w2019.white.ePsyDoc.view.ReportView;

import java.util.List;

public class ReportPresenter implements ReportView.ReportViewListener {
	private PatientModel model;
	private ReportView view;

	public ReportPresenter(PatientModel model, ReportView view) {
		this.model = model;
		this.view = view;
		view.addListener(this);
	}

	@Override
	public void clickNewPatientCase(int patientCaseID, int patientID) {
		Patient tempPatient = model.getPatient((int) VaadinSession.getCurrent().getAttribute("patientID"));
		String tempPatientID = String.valueOf(tempPatient.getPatientID());
		String tempPatientCaseID = tempPatientID + "." + String.valueOf(tempPatient.getPatientCaseList().size());
		model.getPatient(Integer.parseInt(tempPatientID)).addPatientCase(tempPatientCaseID);
	}

	@Override
	public void clickDeletePatientCase() {
		Patient tempPatient = model.getPatient(Integer.parseInt((String) VaadinSession.getCurrent().getAttribute("patientID")));
		tempPatient.removePatientCase(String.valueOf(VaadinSession.getCurrent().getAttribute("patientCaseID")));
	}

	@Override
	public void clickAddMedication(Medication medication) {
		Patient tempPatient = model.getPatient(Integer.parseInt((String) VaadinSession.getCurrent().getAttribute("patientID")));
		PatientCase tempPatientCase = tempPatient.getPatientCase(String.valueOf(VaadinSession.getCurrent().getAttribute("patientCaseID")));
		MedicationPlan medicationPlan = tempPatientCase.getMedicationPlan();
		view.displayPatientCase(tempPatientCase);
//		medicationPlan.addToMedicationPlan(medication);
		medicationPlan.getMedications().add(medication);
		view.displayUpdateMedicationGrid(medicationPlan);
	}

	@Override
	public void clickRemoveFromMedicationPlan(String brandname) {
		Patient tempPatient = model.getPatient(Integer.parseInt((String) VaadinSession.getCurrent().getAttribute("patientID")));
		PatientCase tempPatientCase = tempPatient.getPatientCase(String.valueOf(VaadinSession.getCurrent().getAttribute("patientCaseID")));
	}

	@Override
	public void deleteDiagnose(Diagnosis diagnosis) {
		Patient tempPatient = model.getPatient(Integer.parseInt((String) VaadinSession.getCurrent().getAttribute("patientID")));
		PatientCase tempPatientCase = tempPatient.getPatientCase(String.valueOf(VaadinSession.getCurrent().getAttribute("patientCaseID")));
		Report report = tempPatientCase.getReport();
//		DiagnosisList diagnosisList = report.getDiagnosisList();
		List<Diagnosis> diagnosisList = report.getDiagnosisList();
//		diagnosisList.RemoveFromDiagnosisList(diagnosis);
		diagnosisList.remove(diagnosis);
	}

	@Override
	public void getPatientData() {
		Patient tempPatient = model.getPatient(Integer.parseInt((String) VaadinSession.getCurrent().getAttribute("patientID")));
		view.displayPatientName(tempPatient.getFirstname(), tempPatient.getLastname());

	}

	@Override
	public void getDoctorData() {
		view.displayDoctorName(
				(String) VaadinSession.getCurrent().getAttribute("doctorFirstname"),
				(String) VaadinSession.getCurrent().getAttribute("doctorName")
		);
//		(Doctor) VaadinSession.getCurrent().getAttribute("user")); todo: rückgängig machen - done sugi


	}

	@Override
	public void getPatientCaseID() {
		view.displayPatientCaseID((String) VaadinSession.getCurrent().getAttribute("patientCaseID"));
		
	}

	@Override
	public void getDiagnosis() {
		Patient tempPatient = model.getPatient(Integer.parseInt((String) VaadinSession.getCurrent().getAttribute("patientID")));
		PatientCase tempPatientCase = tempPatient.getPatientCase(String.valueOf(VaadinSession.getCurrent().getAttribute("patientCaseID")));
		Report report = tempPatientCase.getReport();
//		DiagnosisList diagnosisList = report.getDiagnosisList();
		List<Diagnosis> diagnosisList = report.getDiagnosisList();
//		view.displayUpdateDiagnosisGrid(diagnosisList.getDiagnosisList()); todo: meine änderungen - lg sugi
		view.displayUpdateDiagnosisGrid(report.getDiagnosisList());
		
	}

	@Override
	public void getMedications() {
		Patient tempPatient = model.getPatient(Integer.parseInt((String) VaadinSession.getCurrent().getAttribute("patientID")));
		PatientCase tempPatientCase = tempPatient.getPatientCase(String.valueOf(VaadinSession.getCurrent().getAttribute("patientCaseID")));
		MedicationPlan medicationPlan = tempPatientCase.getMedicationPlan();
		view.displayUpdateMedicationGrid(medicationPlan);
		
		
	}

	@Override
	public void clickAddDiagnose(Diagnosis diagnosis) {
		Patient tempPatient = model.getPatient(Integer.parseInt((String) VaadinSession.getCurrent().getAttribute("patientID")));
		PatientCase tempPatientCase = tempPatient.getPatientCase(String.valueOf(VaadinSession.getCurrent().getAttribute("patientCaseID")));
		Report tempReport = tempPatientCase.getReport();
//		DiagnosisList tempDiagnosisList= tempReport.getDiagnosisList();
		List<Diagnosis> tempDiagnosisList = tempReport.getDiagnosisList();
//		tempDiagnosisList.addToDiagnosisList(diagnosis);
		tempDiagnosisList.add(diagnosis);
//		view.displayUpdateDiagnosisGrid(tempDiagnosisList.getDiagnosisList());
		view.displayUpdateDiagnosisGrid(tempDiagnosisList); //tempDianosisList is a List obj itself
		
	}

}
