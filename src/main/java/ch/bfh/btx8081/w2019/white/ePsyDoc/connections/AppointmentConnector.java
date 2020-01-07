package ch.bfh.btx8081.w2019.white.ePsyDoc.connections;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.w2019.white.ePsyDoc.model.AppointmentModel;
import ch.bfh.btx8081.w2019.white.ePsyDoc.presenter.AppointmentPresenter;
import ch.bfh.btx8081.w2019.white.ePsyDoc.view.AppointmentViewImpl;

@Route("Appointment")
@PageTitle("Appointment")

/**
 * @author Alain Nippel
 * @author Apiwat-David Gaupp
 * @author Janahan Sellathurai
 * @author Marko Miletic
 * @author Sugeelan Selvasingham
 * @author Viktor Velkov
 * 
 * @version 1.0
 * 
 *          Connects Appointment Model and View through the Presenter
 */
public class AppointmentConnector extends VerticalLayout {

	/**
	 * * Constructor of Appointment view. Create new Appointment model and view.
	 * Create new presenter with model and view Add view to GUI
	 */
	public AppointmentConnector() {
		AppointmentModel model = new AppointmentModel();
		AppointmentViewImpl view = new AppointmentViewImpl();
		new AppointmentPresenter(model, view);
		add(view);
	}
}
