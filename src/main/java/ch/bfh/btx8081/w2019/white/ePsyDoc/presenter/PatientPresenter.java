package ch.bfh.btx8081.w2019.white.ePsyDoc.presenter;

import ch.bfh.btx8081.w2019.white.ePsyDoc.ModelTemp.PatientModel;
import ch.bfh.btx8081.w2019.white.ePsyDoc.view.PatientView;

public class PatientPresenter implements PatientView.PatientViewListener {
	private PatientModel model;
	private PatientView view;

	public PatientPresenter(PatientModel model, PatientView view) {
	        this.model = model;
	        this.view = view;
	        view.addListener(this);
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
