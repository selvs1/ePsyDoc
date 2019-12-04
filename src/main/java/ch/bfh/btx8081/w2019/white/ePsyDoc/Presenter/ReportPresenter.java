package ch.bfh.btx8081.w2019.white.ePsyDoc.Presenter;

import com.vaadin.flow.server.VaadinSession;

import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.Diagnosis;
import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.DiagnosisList;
import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.Doctor;
import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.Medication;
import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.MedicationPlan;
import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.Patient;
import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.PatientCase;
import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.PatientModel;
import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.Report;
import ch.bfh.btx8081.w2019.white.ePsyDoc.View.ReportView;

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
		Patient tempPatient = model.getPatient((int) VaadinSession.getCurrent().getAttribute("patientID"));
		tempPatient.removePatientCase(String.valueOf(VaadinSession.getCurrent().getAttribute("patientCaseID")));
	}

	@Override
	public void clickAddMedication(Medication medication) {
		Patient tempPatient = model.getPatient((int) VaadinSession.getCurrent().getAttribute("patientID"));
		PatientCase tempPatientCase = tempPatient.getPatientCase(String.valueOf(VaadinSession.getCurrent().getAttribute("patientCaseID")));
		MedicationPlan medicationPlan = tempPatientCase.getMedicationPlan();
		medicationPlan.addToMedicationPlan(medication);
	}

	@Override
	public void clickRemoveFromMedicationPlan(String brandname) {
		Patient tempPatient = model.getPatient((int) VaadinSession.getCurrent().getAttribute("patientID"));
		PatientCase tempPatientCase = tempPatient.getPatientCase(String.valueOf(VaadinSession.getCurrent().getAttribute("patientCaseID")));
	}

	@Override
	public void deleteDiagnose(Diagnosis diagnosis) {
		Patient tempPatient = model.getPatient((int) VaadinSession.getCurrent().getAttribute("patientID"));
		PatientCase tempPatientCase = tempPatient.getPatientCase(String.valueOf(VaadinSession.getCurrent().getAttribute("patientCaseID")));
		Report report = tempPatientCase.getReport();
		DiagnosisList diagnosisList = report.getDiagnosisList();
		diagnosisList.RemoveFromDiagnosisList(diagnosis);		
	}
}
