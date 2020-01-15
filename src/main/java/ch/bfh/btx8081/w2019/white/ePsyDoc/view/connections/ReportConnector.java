package ch.bfh.btx8081.w2019.white.ePsyDoc.view.connections;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.w2019.white.ePsyDoc.model.ReportModel;
import ch.bfh.btx8081.w2019.white.ePsyDoc.presenter.ReportPresenter;
import ch.bfh.btx8081.w2019.white.ePsyDoc.view.ReportViewImpl;

@Route("Report")
@PageTitle("Report")
/**
 * Connects Report Model and View through the Presenter.
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
public class ReportConnector extends VerticalLayout {
	/**
	 * * Constructor of Report view. Create new Report model and view. Create new
	 * presenter with model and view Add view to GUI.
	 */
	public ReportConnector() {
		ReportModel model = new ReportModel();
		ReportViewImpl view = new ReportViewImpl();
		new ReportPresenter(model, view);
		add(view);
	}
}
