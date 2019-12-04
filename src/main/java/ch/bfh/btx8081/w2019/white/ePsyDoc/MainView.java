package ch.bfh.btx8081.w2019.white.ePsyDoc;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.LoginModel;
import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.PatientModel;
import ch.bfh.btx8081.w2019.white.ePsyDoc.Presenter.LoginPresenter;
import ch.bfh.btx8081.w2019.white.ePsyDoc.Presenter.PatientPresenter;
import ch.bfh.btx8081.w2019.white.ePsyDoc.View.LoginViewImpl;
import ch.bfh.btx8081.w2019.white.ePsyDoc.View.PatientViewImpl;

@Route("")
public class MainView extends VerticalLayout {

	public MainView() {
		setupLogin();
		//setupAppointment();
		setupPatient();
		//setupLogout();
	}

	// LoginModel
	private void setupLogin() {
		LoginModel model = new LoginModel();
		model.init();
		LoginViewImpl view = new LoginViewImpl();
		new LoginPresenter(model, view);
		add(view);
	}

	/*
	 * private void setupAppointment() { AppointmentModel model = new
	 * AppointmentModel(); model.init(); AppointmentViewImpl view = new
	 * AppointmentViewImpl(); new AppointmentPresenter(model, view); add(view); }
	 */

	//PatientModel
	private void setupPatient() {
		PatientModel model = new PatientModel();
		//model.init();
		PatientViewImpl view = new PatientViewImpl();
		new PatientPresenter(model, view);
		add(view);
	}

	/*
	 * 
	 * private void setupLogout() { LogoutModel model = new LogoutModel();
	 * model.init(); LogoutViewImpl view = new LogoutViewImpl(); new
	 * LogoutPresenter(model, view); add(view); }
	 */
}
