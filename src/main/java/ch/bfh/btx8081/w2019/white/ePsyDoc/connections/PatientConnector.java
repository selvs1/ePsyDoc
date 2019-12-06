package ch.bfh.btx8081.w2019.white.ePsyDoc.connections;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.w2019.white.ePsyDoc.model.PatientModel;
import ch.bfh.btx8081.w2019.white.ePsyDoc.presenter.PatientPresenter;
import ch.bfh.btx8081.w2019.white.ePsyDoc.view.PatientViewImpl;

@Route("Patient")
@PageTitle("Patient")
public class PatientConnector extends VerticalLayout {
	private static final long serialVersionUID = 1L;

	public PatientConnector() {
		PatientModel model = new PatientModel();
		model.init();
		PatientViewImpl view = new PatientViewImpl();
		new PatientPresenter(model, view);
		add(view);
	}
}
