package ch.bfh.btx8081.w2019.white.ePsyDoc.connections;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.w2019.white.ePsyDoc.ModelTemp.PatientModel;
import ch.bfh.btx8081.w2019.white.ePsyDoc.PresenterTemp.ReportPresenter;
import ch.bfh.btx8081.w2019.white.ePsyDoc.ViewTemp.ReportViewImpl;

@Route("Report")
@PageTitle("Report")
public class ReportConnector extends VerticalLayout {
	private static final long serialVersionUID = 1L;

	public ReportConnector() {
		PatientModel model = new PatientModel();
		model.init();
		ReportViewImpl view = new ReportViewImpl();
		new ReportPresenter(model, view);
		add(view);
	}
}

