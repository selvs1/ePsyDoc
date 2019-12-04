package ch.bfh.btx8081.w2019.white.ePsyDoc.Presenter;

import java.util.ArrayList;

import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.PatientCase;
import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.PatientModel;
import ch.bfh.btx8081.w2019.white.ePsyDoc.View.PatientView;

public class PatientPresenter implements PatientView.PatientViewListener {
	private PatientModel model;
	private PatientView view;

	public PatientPresenter(PatientModel model, PatientView view) {
	        this.model = model;
	        this.view = view;
	        view.addListener(this);
	    }

	@Override
	public void clickNewPatientModel(int patientID, String lastname, String firstname, String gender, String date,
			String adress, String zip, ArrayList<PatientCase> patientCaseList) {		
	}

	@Override
	public void clickGetPatientName(PatientModel patient) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clickGetPatientID(PatientModel patient) {
		// TODO Auto-generated method stub
		
	}
	


	
}
