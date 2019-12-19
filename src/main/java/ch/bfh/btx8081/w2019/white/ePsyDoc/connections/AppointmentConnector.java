package ch.bfh.btx8081.w2019.white.ePsyDoc.connections;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.w2019.white.ePsyDoc.model.AppointmentModel;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.PatientModel;
import ch.bfh.btx8081.w2019.white.ePsyDoc.presenter.AppointmentPresenter;
import ch.bfh.btx8081.w2019.white.ePsyDoc.view.AppointmentViewImpl;

@Route("Appointment")
@PageTitle("Appointment")
public class AppointmentConnector extends VerticalLayout {
	private static final long serialVersionUID = 1L;

	public AppointmentConnector() {
		AppointmentModel model = new AppointmentModel();
		model.init();
		AppointmentViewImpl view = new AppointmentViewImpl();
		new AppointmentPresenter(model, view);
		add(view);
	}
}
