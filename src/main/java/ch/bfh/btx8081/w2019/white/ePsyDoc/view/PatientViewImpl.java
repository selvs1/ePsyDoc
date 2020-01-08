package ch.bfh.btx8081.w2019.white.ePsyDoc.view;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.HeaderRow;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.server.VaadinSession;

import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Doctor;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Patient;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.PatientCase;

/**
 * @author Alain Nippel
 * @author Apiwat-David Gaupp
 * @author Janahan Sellathurai
 * @author Marko Miletic
 * @author Sugeelan Selvasingham
 * @author Viktor Velkov
 * 
 * @version 1.0
 * 
 *          Setup patient GUI.
 */
public class PatientViewImpl extends MainLayoutView implements PatientView {
	private static final long serialVersionUID = 1L;
	private VerticalLayout root = new VerticalLayout();
	private List<Patient> patientList = new ArrayList<>();
	private Grid<Patient> patientG = new Grid<>();
	private Grid<PatientCase> patientCaseG = new Grid<>();
	private Button newB = new Button(new Icon(VaadinIcon.FILE_ADD));
	private ListDataProvider<Patient> dataProvider = new ListDataProvider<Patient>(patientList);
	private List<PatientViewListener> listeners = new ArrayList<>();
	private Patient patient;
	private Doctor doctor;

	/**
	 * Constructor generate the GUI.
	 */
	public PatientViewImpl() {
		// Load Data
		this.addAttachListener(e -> {
			for (PatientViewListener listener : listeners) {
				listener.loadPatientCaseList();
			}
		});

		// PatientCase Grid setup.
		patientCaseG.addColumn(PatientCase::getDate).setHeader("Patient Case");
		patientCaseG.addColumn(PatientCase::getPatientcaseID).setVisible(false);

		// Patient Grid setup.
		patientG.addColumn(Patient::getPatientID).setHeader("Patient ID");
		Grid.Column<Patient> firstNameColumn = patientG.addColumn(Patient::getFirstname).setHeader("Firstname");
		Grid.Column<Patient> lastNameColumn = patientG.addColumn(Patient::getLastname).setHeader("Lastname");
		patientG.addColumn(Patient::getGender).setHeader("Gender");
		patientG.addColumn(Patient::getDate).setHeader("Birthdate");
		patientG.addColumn(Patient::getAdress).setHeader("Address");
		patientG.addColumn(Patient::getZip).setHeader("ZIP");

		// On click listener choose patient.
		patientG.addItemClickListener(event -> {
			VaadinSession.getCurrent().setAttribute("patientID", event.getItem().getPatientID());
			VaadinSession.getCurrent().setAttribute("patientFirstname", event.getItem().getFirstname());
			VaadinSession.getCurrent().setAttribute("patientName", event.getItem().getLastname());
			VaadinSession.getCurrent().setAttribute("patientCaseID", null);

			// Load patient case.
			for (PatientViewListener listener : listeners) {
				int patientID = event.getItem().getPatientID();
				VaadinSession.getCurrent().setAttribute("patientID", patientID);
				listener.setPatientCaseList(patientID);
			}

			// Update patient case Grid.
			patientCaseG.setVisible(true);
			newB.setVisible(true);
			patientCaseG.getDataProvider().refreshAll();
		});
		// On click open patient case.
		patientCaseG.addItemClickListener(event -> {
			VaadinSession.getCurrent().setAttribute("patientCaseID", event.getItem().getPatientcaseID());
			UI.getCurrent().navigate("Report");
		});

		// Setup patient filter.
		patientG.setDataProvider(dataProvider);
		HeaderRow filterRow = patientG.appendHeaderRow();

		// First name filter.
		TextField firstNameField = new TextField();
		firstNameField.addValueChangeListener(event -> dataProvider.addFilter(
				patient -> StringUtils.containsIgnoreCase(patient.getFirstname(), firstNameField.getValue())));
		firstNameField.setValueChangeMode(ValueChangeMode.EAGER);
		filterRow.getCell(firstNameColumn).setComponent(firstNameField);
		firstNameField.setSizeFull();
		firstNameField.setPlaceholder("Filter");

		// Last name filter.
		TextField lastNameField = new TextField();
		lastNameField.addValueChangeListener(event -> dataProvider
				.addFilter(patient -> StringUtils.containsIgnoreCase(patient.getLastname(), lastNameField.getValue())));
		lastNameField.setValueChangeMode(ValueChangeMode.EAGER);
		filterRow.getCell(lastNameColumn).setComponent(lastNameField);
		lastNameField.setSizeFull();
		lastNameField.setPlaceholder("Filter");

		// Set visability of create Button and patient case Grid.
		patientCaseG.setVisible(false);
		newB.setVisible(false);

		// On click create patient case.
		newB.addClickListener(e -> {
			for (PatientViewListener listener : listeners) {
				listener.getPatientObject(
						Integer.parseInt(VaadinSession.getCurrent().getAttribute("patientID").toString()));
				listener.getDoctorObject(
						Integer.parseInt(VaadinSession.getCurrent().getAttribute("doctorID").toString()));
				PatientCase pc = new PatientCase(patient, doctor);
				listener.addPatientCase(pc,
						Integer.parseInt(VaadinSession.getCurrent().getAttribute("patientID").toString()));
			}
		});

		// Add elements to root VerticalLayout.
		root.add(patientG, patientCaseG, newB);

		// Add to layout.
		super.content.add(root);
	}

	/**
	 * @param listeners add listeners.
	 * 
	 *                  Add listeners.
	 */
	@Override
	public void addListener(PatientViewListener listener) {
		listeners.add(listener);
	}

	/**
	 * @param patientList get patientList from presenter.
	 * 
	 *                    set patientList and create new ListenDataProvider and fill
	 *                    data in patient Grid.
	 */
	@Override
	public void displayPatientList(List<Patient> patientList) {
		this.patientList = patientList;
		dataProvider = new ListDataProvider<Patient>(patientList);
		patientG.setDataProvider(dataProvider);
	}

	/**
	 * @param patientCaseList get patientCaseList from presenter.
	 * 
	 *                        set patient case Grid
	 */
	@Override
	public void displayPatientCaseList(List<PatientCase> patientCaseList) {
		this.patientCaseG.setItems(patientCaseList);
	}

	/**
	 * @param patient get patient from presenter.
	 * 
	 *                set patient.
	 */
	@Override
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	/**
	 * @param doctor get doctor from presenter.
	 * 
	 *               set doctor.
	 */
	@Override
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
}