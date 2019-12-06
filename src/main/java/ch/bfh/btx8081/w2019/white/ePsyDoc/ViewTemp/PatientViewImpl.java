package ch.bfh.btx8081.w2019.white.ePsyDoc.ViewTemp;

import java.util.ArrayList;
import java.util.List;

import ch.bfh.btx8081.w2019.white.ePsyDoc.view.PatientView;
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
import ch.bfh.btx8081.w2019.white.ePsyDoc.ModelTemp.Patient;
import ch.bfh.btx8081.w2019.white.ePsyDoc.ModelTemp.PatientCase;
import ch.bfh.btx8081.w2019.white.ePsyDoc.ModelTemp.PatientModel;

public class PatientViewImpl extends MainLayoutView implements PatientView {
	private static final long serialVersionUID = 1L;
	private List<Patient> patientlist = new ArrayList<>();
	private VerticalLayout root = new VerticalLayout();
	private List<Patient> personList = new ArrayList<>();
	private Grid<Patient> grid = new Grid<>();
	private Grid<PatientCase> patientCase = new Grid<>();
	private List<PatientCase> patientCaseList = new ArrayList<>();

	public PatientViewImpl() {
		 if(VaadinSession.getCurrent().getAttribute("name")== null) {
			   UI.getCurrent().navigate(MainView.class);
		 }
		// Test Data
		
		// Column set and description
		grid.addColumn(Patient::getPatientID).setHeader("Patient ID");
		Grid.Column<Patient> firstNameColumn = grid.addColumn(Patient::getFirstname).setHeader("Firstname");
		Grid.Column<Patient> lastNameColumn = grid.addColumn(Patient::getLastname).setHeader("Lastname");
		grid.addColumn(Patient::getGender).setHeader("Gender");
		grid.addColumn(Patient::getDate).setHeader("Birthdate");
		grid.addColumn(Patient::getAdress).setHeader("Address");
		grid.addColumn(Patient::getZIP).setHeader("ZIP");

		// Data provider
		ListDataProvider<Patient> dataProvider = new ListDataProvider<>(patientlist);
		grid.setDataProvider(dataProvider);
		HeaderRow filterRow = grid.appendHeaderRow();

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
		//patientCase.addColumn(PatientCase::getFid).setHeader("FID");
		patientCase.setVisible(false);
		patientCase.setItems(patientCaseList);

		// double click on patient item show patientCase Grid
		grid.addItemClickListener(e -> patientCase.setVisible(true));

		// Add elements to root VerticalLayout
		root.add( grid, patientCase);

		// Add to layout
		super.content.add(root);
	}

	@Override
	public void addListener(PatientViewListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayPatientData(PatientModel patientModel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayPatientCaseData(PatientModel patientModel) {
		// TODO Auto-generated method stub
		
	}


}
