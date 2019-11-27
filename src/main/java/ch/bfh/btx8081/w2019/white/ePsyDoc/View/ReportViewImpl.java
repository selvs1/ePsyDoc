package ch.bfh.btx8081.w2019.white.ePsyDoc.View;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("Report")
@PageTitle("Report")
public class ReportViewImpl extends MainLayoutView implements MedicationView {

	public ReportViewImpl() {
		
		
		VerticalLayout root = new VerticalLayout();
		
		root.add(new MedicationViewImpl());
		content.add(root);
	}
}
