package ch.bfh.btx8081.w2019.white.ePsyDoc.View;

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
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;

import ch.bfh.btx8081.w2019.white.ePsyDoc.MainView;
import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.PatientCase;
import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.PatientModel;
import ch.bfh.btx8081.w2019.white.ePsyDoc.View.MedicationPlanView.MedicationPlanViewListener;
import ch.bfh.btx8081.w2019.white.ePsyDoc.View.PatientView.PatientViewListener;

@Route("Patient")
@PageTitle("Patient")
public class PatientViewImpl extends MainLayoutView implements PatientView {
	private static final long serialVersionUID = 1L;
	private List<PatientModel> patientlist = new ArrayList<>();
	private VerticalLayout root = new VerticalLayout();
	private List<PatientModel> personList = new ArrayList<>();
	private Grid<PatientModel> grid = new Grid<>();
	private Grid<PatientCase> patientCase = new Grid<>();
	private List<PatientCase> patientCaseList = new ArrayList<>();

	public PatientViewImpl() {
		 if(VaadinSession.getCurrent().getAttribute("name")== null) {
			   UI.getCurrent().navigate(MainView.class);
		 }
		// Test Data
		
		// Column set and description
		grid.addColumn(PatientModel::getPatientID).setHeader("Patient ID");
		Grid.Column<PatientModel> firstNameColumn = grid.addColumn(PatientModel::getFirstname).setHeader("Firstname");
		Grid.Column<PatientModel> lastNameColumn = grid.addColumn(PatientModel::getLastname).setHeader("Lastname");
		grid.addColumn(PatientModel::getGender).setHeader("Gender");
		grid.addColumn(PatientModel::getDate).setHeader("Birthdate");
		grid.addColumn(PatientModel::getAdress).setHeader("Address");
		grid.addColumn(PatientModel::getZIP).setHeader("ZIP");

		// Data provider
		ListDataProvider<PatientModel> dataProvider = new ListDataProvider<>(patientlist);
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

}
