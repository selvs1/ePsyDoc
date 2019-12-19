package ch.bfh.btx8081.w2019.white.ePsyDoc.connections;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.w2019.white.ePsyDoc.model.ReportModel;
import ch.bfh.btx8081.w2019.white.ePsyDoc.presenter.ReportPresenter;
import ch.bfh.btx8081.w2019.white.ePsyDoc.view.ReportViewImpl;

@Route("Report")
@PageTitle("Report")
public class ReportConnector extends VerticalLayout {
	private static final long serialVersionUID = 1L;

	public ReportConnector() {
		ReportModel model = new ReportModel();
		ReportViewImpl view = new ReportViewImpl();
		new ReportPresenter(model, view);
		add(view);
	}
}

