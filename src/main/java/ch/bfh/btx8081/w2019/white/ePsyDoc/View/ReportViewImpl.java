package ch.bfh.btx8081.w2019.white.ePsyDoc.View;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.HospIndex;
import ch.bfh.btx8081.w2019.white.ePsyDoc.View.LoginView.LoginViewListener;

@Route("Report")
@PageTitle("Report")
public class ReportViewImpl extends MainLayoutView implements ReportView {
	private static final long serialVersionUID = 1L;
	private VerticalLayout root = new VerticalLayout();
	private MedicationPlanViewImpl medicationView = new MedicationPlanViewImpl();
	private Button newB = new Button(new Icon(VaadinIcon.FILE_ADD));
	private Button deleteB = new Button(new Icon(VaadinIcon.FILE_REMOVE));
	private Button addB = new Button(new Icon(VaadinIcon.PLUS));
	private TextField diagnoseT = new TextField();
	private Grid diagnoseG = new Grid();
	private VerticalLayout information = new VerticalLayout();
	private HorizontalLayout patientCaseLayout = new HorizontalLayout();
	private HorizontalLayout doctorLayout = new HorizontalLayout();
	private HorizontalLayout patientLayout = new HorizontalLayout();
	private Icon doctorI = new Icon(VaadinIcon.DOCTOR);
	private Icon patientI = new Icon(VaadinIcon.USER);
	private Icon patientCaseI = new Icon(VaadinIcon.CLIPBOARD_CROSS);
	private Label patientCaseL = new Label("123");
	private Label doctorPrenameL = new Label("Doctor");
	private Label doctorSurnameL = new Label("D");
	private Label patientPrenameL = new Label("Patient");
	private Label patientSurnameL = new Label("P");
	private Tab tab1 = new Tab("C 2019.08.10");
	private Tab tab2 = new Tab("C 2019.10.04");
	private Tab tab3 = new Tab("C 2019.11.22");
	private Tabs tabs = new Tabs(tab1, tab2, tab3);
	private TextArea consultation = new TextArea("Consultation");
	private List<ReportViewListener> listeners = new ArrayList<>();

	public ReportViewImpl() {
		
		// medicationView settings
		medicationView.setWidth("100%");

		// consultation editor settings
		consultation.setWidth("100%");
		
		// set header informations
		doctorLayout.add(doctorI,doctorPrenameL, doctorSurnameL);
		patientLayout.add(patientI,patientPrenameL, patientSurnameL);
		patientCaseLayout.add(patientCaseI, patientCaseL);
		information.add(doctorLayout, patientLayout,patientCaseLayout);
		
		// set Grid header
		// set diagnose TextField settings
		diagnoseT.setLabel("Diagnose");
		
		// Tabs settings
		tabs.setFlexGrowForEnclosedTabs(1);
		tabs.setWidth("100%");

		// Add to layout
		root.add(tabs, newB,information, consultation, diagnoseT, addB, diagnoseG, medicationView, deleteB);
		super.content.add(root);
	}

	@Override
	public void addListener(ReportViewListener listener) {
		listeners.add(listener);
	}

	@Override
	public void displayPatientCaseTabs(int patientCaseID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayDoctorName(int doctorID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayPatientName(int patientID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayPatientCaseID(int patientCaseID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayComboBox(HospIndex hospIndex) {
		// TODO Auto-generated method stub
		
	}
}
