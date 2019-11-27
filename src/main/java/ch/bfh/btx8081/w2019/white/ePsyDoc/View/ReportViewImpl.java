package ch.bfh.btx8081.w2019.white.ePsyDoc.View;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.richtexteditor.RichTextEditor;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("Report")
@PageTitle("Report")
public class ReportViewImpl extends MainLayoutView implements MedicationView {

	public ReportViewImpl() {
		VerticalLayout root = new VerticalLayout();
		MedicationViewImpl medicationView = new MedicationViewImpl();
		medicationView.setWidth("100%");
		
		RichTextEditor consultation = new RichTextEditor("Consultation");
		consultation.setWidth("100%");
		
		Button newB = new Button("New");
		Button saveB = new Button("Save");
		Button deleteB = new Button("Delete");

		Tab tab1 = new Tab("C 2019.08.10");
		Tab tab2 = new Tab("C 2019.10.04");
		Tab tab3 = new Tab("C 2019.11.22");

		Tabs tabs = new Tabs(tab1, tab2, tab3);
		tabs.setFlexGrowForEnclosedTabs(1);
		tabs.setWidth("100%");

		root.add(tabs,newB,consultation,medicationView,saveB,deleteB);
		content.add(root);
	}
}
