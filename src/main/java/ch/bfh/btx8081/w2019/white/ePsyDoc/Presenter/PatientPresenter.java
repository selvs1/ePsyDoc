package ch.bfh.btx8081.w2019.white.ePsyDoc.Presenter;

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

}
