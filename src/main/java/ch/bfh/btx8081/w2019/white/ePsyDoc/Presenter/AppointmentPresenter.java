package ch.bfh.btx8081.w2019.white.ePsyDoc.Presenter;

import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.PatientModel;
import ch.bfh.btx8081.w2019.white.ePsyDoc.View.AppointmentView;

public class AppointmentPresenter implements AppointmentView.AppointmentViewListener {
	private PatientModel model;
	private AppointmentView view;

	public AppointmentPresenter(PatientModel model, AppointmentView view) {
	        this.model = model;
	        this.view = view;
	        view.addListener(this);
	    }

}
