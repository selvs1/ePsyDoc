package ch.bfh.btx8081.w2019.white.ePsyDoc.Presenter;

import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.Doctor;
import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.Medication;
import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.PatientCase;
import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.PatientModel;
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
	public void save(int intervall) {
	}

	@Override
	public void clickSetFields(PatientCase patientcase) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clickNewReport(Doctor doctor, PatientModel patient) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clickNewPatientCase(int patientCaseID, int patientID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clickDeletePatientCase() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDiagnose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clickSetMedicationPlan(int patientcaseID, int patientID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clickDisableFields() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clickAutofill() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clickAddMedication(Medication medication) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clickRemoveFromMedicationPlan(String brandname) {
		// TODO Auto-generated method stub
		
	}

	

}
