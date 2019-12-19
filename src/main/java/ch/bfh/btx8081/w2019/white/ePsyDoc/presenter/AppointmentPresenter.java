package ch.bfh.btx8081.w2019.white.ePsyDoc.presenter;

import ch.bfh.btx8081.w2019.white.ePsyDoc.model.AppointmentModel;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.PatientModel;
import ch.bfh.btx8081.w2019.white.ePsyDoc.view.AppointmentView;

public class AppointmentPresenter implements AppointmentView.AppointmentViewListener {
	private AppointmentModel model;
	private AppointmentView view;

	public AppointmentPresenter(AppointmentModel model, AppointmentView view) {
	        this.model = model;
	        this.view = view;
	        view.addListener(this);
	    }

}