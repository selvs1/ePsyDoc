package ch.bfh.btx8081.w2019.white.ePsyDoc.View;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("Report")
@PageTitle("Report")
public class ReportViewImpl extends MainLayoutView implements MedicationView {

	public ReportViewImpl() {
		super.content.add(new Button("ReportViewImpl"));
		
	}
}
