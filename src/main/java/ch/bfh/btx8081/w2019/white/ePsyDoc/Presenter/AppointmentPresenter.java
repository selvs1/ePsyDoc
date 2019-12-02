package ch.bfh.btx8081.w2019.white.ePsyDoc.Presenter;

import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.AppointmentModel;
import ch.bfh.btx8081.w2019.white.ePsyDoc.View.AppointmentView;

public class AppointmentPresenter implements AppointmentView.AppointmentViewListener {
	private AppointmentModel model;
	private AppointmentView view;

	public AppointmentPresenter(AppointmentModel model, AppointmentView view) {
	        this.model = model;
	        this.view = view;
	        view.addListener(this);
	    }

}
