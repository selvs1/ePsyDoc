package ch.bfh.btx8081.w2019.white.ePsyDoc.Presenter;

import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.Appointment;
import ch.bfh.btx8081.w2019.white.ePsyDoc.View.AppointmentView;

public class AppointmentPresenter implements AppointmentView.AppointmentViewListener {
	private Appointment model;
	private AppointmentView view;

	public AppointmentPresenter(Appointment model, AppointmentView view) {
	        this.model = model;
	        this.view = view;
	        view.addListener(this);
	    }

}
