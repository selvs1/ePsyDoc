package ch.bfh.btx8081.w2019.white.ePsyDoc.connections;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.w2019.white.ePsyDoc.model.PatientModel;
import ch.bfh.btx8081.w2019.white.ePsyDoc.presenter.PatientPresenter;
import ch.bfh.btx8081.w2019.white.ePsyDoc.view.PatientViewImpl;

@Route("Patient")
@PageTitle("Patient")
/**
 * Connects Patient Model and View through the Presenter.
 * 
 * @author Alain Nippel
 * @author Apiwat-David Gaupp
 * @author Janahan Sellathurai
 * @author Marko Miletic
 * @author Sugeelan Selvasingham
 * @author Viktor Velkov
 * 
 * @version 1.0
 */
public class PatientConnector extends VerticalLayout {

	/**
	 * * Constructor of Patient view. Create new Patient model and view. Create new
	 * presenter with model and view Add view to GUI.
	 */
	public PatientConnector() {
		PatientModel model = new PatientModel();
		model.init();
		PatientViewImpl view = new PatientViewImpl();
		new PatientPresenter(model, view);
		add(view);
	}
}
