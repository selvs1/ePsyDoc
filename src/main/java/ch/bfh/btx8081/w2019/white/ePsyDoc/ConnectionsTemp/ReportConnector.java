package ch.bfh.btx8081.w2019.white.ePsyDoc.ConnectionsTemp;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.PatientModel;
import ch.bfh.btx8081.w2019.white.ePsyDoc.Presenter.ReportPresenter;
import ch.bfh.btx8081.w2019.white.ePsyDoc.View.ReportViewImpl;

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

