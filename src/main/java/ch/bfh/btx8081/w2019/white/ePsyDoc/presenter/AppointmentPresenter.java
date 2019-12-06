package ch.bfh.btx8081.w2019.white.ePsyDoc.presenter;

import ch.bfh.btx8081.w2019.white.ePsyDoc.ModelTemp.PatientModel;
import ch.bfh.btx8081.w2019.white.ePsyDoc.view.AppointmentView;

public class AppointmentPresenter implements AppointmentView.AppointmentViewListener {
	private PatientModel model;
	private AppointmentView view;

	public AppointmentPresenter(PatientModel model, AppointmentView view) {
	        this.model = model;
	        this.view = view;
	        view.addListener(this);
	    }

}
