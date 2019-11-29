package ch.bfh.btx8081.w2019.white.ePsyDoc.View;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("Report")
@PageTitle("Report")
public class ReportViewImpl extends MainLayoutView implements MedicationView {
	private static final long serialVersionUID = 1L;
	private VerticalLayout root = new VerticalLayout();
	private MedicationViewImpl medicationView = new MedicationViewImpl();
	private Button newB = new Button(new Icon(VaadinIcon.FILE_ADD));
	private Button saveB = new Button(new Icon(VaadinIcon.CHECK));
	private Button deleteB = new Button(new Icon(VaadinIcon.FILE_REMOVE));
	private Tab tab1 = new Tab("C 2019.08.10");
	private Tab tab2 = new Tab("C 2019.10.04");
	private Tab tab3 = new Tab("C 2019.11.22");
	private Tabs tabs = new Tabs(tab1, tab2, tab3);
	private TextArea consultation = new TextArea("Consultation");

	public ReportViewImpl() {
		// medicationView settings
		medicationView.setWidth("100%");

		// consultation editor settings
		consultation.setWidth("100%");

		// Tabs settings
		tabs.setFlexGrowForEnclosedTabs(1);
		tabs.setWidth("100%");

		// Add to layout
		root.add(tabs, newB, consultation, medicationView, saveB, deleteB);
		super.content.add(root);
	}
}
