package ch.bfh.btx8081.w2019.white.ePsyDoc.view;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.HeaderRow;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.server.VaadinSession;

import ch.bfh.btx8081.w2019.white.ePsyDoc.MainView;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Patient;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.PatientCase;

public class PatientViewImpl extends MainLayoutView implements PatientView {
	private static final long serialVersionUID = 1L;
	private VerticalLayout root = new VerticalLayout();
	private List<Patient> patientList = new ArrayList<>();
	private Grid<Patient> patient = new Grid<>();
	private Grid<PatientCase> patientCase = new Grid<>();
	private ListDataProvider<Patient> dataProvider = new ListDataProvider<Patient>(patientList);
	private List<PatientViewListener> listeners = new ArrayList<>();

	public PatientViewImpl() {
		// Load Data
		this.addAttachListener(e -> {
			for (PatientViewListener listener : listeners) {
				listener.loadPatientCaseList();
			}
		});

		// PatientCase Grid setup
		patientCase.addColumn(PatientCase::getDate).setHeader("Patient Case");
		patientCase.addColumn(PatientCase::getPatientcaseID).setVisible(false);

		// Patient Grid setup
		patient.addColumn(Patient::getPatientID).setHeader("Patient ID");
		Grid.Column<Patient> firstNameColumn = patient.addColumn(Patient::getFirstname).setHeader("Firstname");
		Grid.Column<Patient> lastNameColumn = patient.addColumn(Patient::getLastname).setHeader("Lastname");
		patient.addColumn(Patient::getGender).setHeader("Gender");
		patient.addColumn(Patient::getDate).setHeader("Birthdate");
		patient.addColumn(Patient::getAdress).setHeader("Address");
		patient.addColumn(Patient::getZip).setHeader("ZIP");

		// Click listener Patient
		patient.addItemClickListener(event -> {
			VaadinSession.getCurrent().setAttribute("patientID", event.getItem().getPatientID());
			VaadinSession.getCurrent().setAttribute("patientFirstname", event.getItem().getFirstname());
			VaadinSession.getCurrent().setAttribute("patientName", event.getItem().getLastname());
			VaadinSession.getCurrent().setAttribute("patientCaseID", null);

			// Get PatienCase
			for (PatientViewListener listener : listeners) {
				int patientID = event.getItem().getPatientID();
				listener.setPatientCaseList(patientID);
			}

			// Update PatientCase Grid
			patientCase.setVisible(true);
			patientCase.getDataProvider().refreshAll();
		});
		// Click listener PatientCase
		patientCase.addItemClickListener(event -> {
			VaadinSession.getCurrent().setAttribute("patientCaseID", event.getItem().getPatientcaseID());
			UI.getCurrent().navigate("Report");
		});

		// Data provider
		patient.setDataProvider(dataProvider);
		HeaderRow filterRow = patient.appendHeaderRow();

		// Firstname filter
		TextField firstNameField = new TextField();
		firstNameField.addValueChangeListener(event -> dataProvider.addFilter(
				patient -> StringUtils.containsIgnoreCase(patient.getFirstname(), firstNameField.getValue())));
		firstNameField.setValueChangeMode(ValueChangeMode.EAGER);
		filterRow.getCell(firstNameColumn).setComponent(firstNameField);
		firstNameField.setSizeFull();
		firstNameField.setPlaceholder("Filter");

		// Lastname filter
		TextField lastNameField = new TextField();
		lastNameField.addValueChangeListener(event -> dataProvider
				.addFilter(patient -> StringUtils.containsIgnoreCase(patient.getLastname(), lastNameField.getValue())));
		lastNameField.setValueChangeMode(ValueChangeMode.EAGER);
		filterRow.getCell(lastNameColumn).setComponent(lastNameField);
		lastNameField.setSizeFull();
		lastNameField.setPlaceholder("Filter");

		// Column set, description and settings
		patientCase.setVisible(false);

		// Add elements to root VerticalLayout
		root.add(patient, patientCase);

		// Add to layout
		super.content.add(root);
	}

	@Override
	public void addListener(PatientViewListener listener) {
		listeners.add(listener);
	}

	@Override
	public void displayPatientList(List<Patient> patientList) {
		this.patientList = patientList;
		dataProvider = new ListDataProvider<Patient>(patientList);
		patient.setDataProvider(dataProvider);
	}

	@Override
	public void displayPatientCaseList(List<PatientCase> patientCaseList) {
		this.patientCase.setItems(patientCaseList);
	}
}