package ch.bfh.btx8081.w2019.white.ePsyDoc.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.server.VaadinSession;

import ch.bfh.btx8081.w2019.white.ePsyDoc.model.HospIndex;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Diagnosis;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Doctor;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Drug;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Medication;
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
 *          Setup report GUI
 */
public class ReportViewImpl extends MainLayoutView implements ReportView {
	private VerticalLayout information = new VerticalLayout();
	private VerticalLayout root = new VerticalLayout();
	private HorizontalLayout layout2 = new HorizontalLayout();
	private HorizontalLayout layout3 = new HorizontalLayout();
	private HorizontalLayout layout4 = new HorizontalLayout();
	private HorizontalLayout patientCaseLayout = new HorizontalLayout();
	private HorizontalLayout doctorLayout = new HorizontalLayout();
	private HorizontalLayout patientLayout = new HorizontalLayout();
	private TextField textfieldactiveIngredient = new TextField("Active Ingredient");
	private TextField textfieldbrandName = new TextField("Brand name");
	private TextField textfieldStrength = new TextField("Strength");
	private TextField textfieldForm = new TextField("Form");
	private TextField textfieldMorning = new TextField("Morning");
	private TextField textfieldNoon = new TextField("Noon");
	private TextField textfieldEvening = new TextField("Evening");
	private TextField textfieldAtBedtime = new TextField("At bedtime");
	private TextField textfieldUnit = new TextField("Unit");
	private TextField textfieldInstructions = new TextField("Instructions");
	private TextField textfieldIndication = new TextField("Indication");
	private TextField diagnosisT = new TextField();
	private Button addMedicationB = new Button(new Icon(VaadinIcon.PLUS));
	private Button removeMedicationB = new Button(new Icon(VaadinIcon.MINUS));
	private Button newB = new Button(new Icon(VaadinIcon.FILE_ADD));
	private Button deleteB = new Button(new Icon(VaadinIcon.FILE_REMOVE));
	private Button addDiagnosisB = new Button(new Icon(VaadinIcon.PLUS));
	private Button removeDiagnosisB = new Button(new Icon(VaadinIcon.MINUS));
	private Icon doctorI = new Icon(VaadinIcon.DOCTOR);
	private Icon patientI = new Icon(VaadinIcon.USER);
	private Icon patientCaseI = new Icon(VaadinIcon.CLIPBOARD_CROSS);
	private Label patientCaseL = new Label();
	private Label doctorFirstnameL = new Label();
	private Label doctorNameL = new Label();
	private Label patientFirstnameL = new Label();
	private Label patientNameL = new Label();
	private Tabs tabs = new Tabs();
	private Grid<Medication> medicationG = new Grid<Medication>();
	private Grid<Diagnosis> diagnosisG = new Grid<Diagnosis>();
	private TextArea consultationTA = new TextArea("Consultation");
	private ComboBox<String> combo = new ComboBox<String>("Active Ingredient");
	private List<ReportViewListener> listeners = new ArrayList<>();
	private List<Medication> medicationList = new ArrayList<>();
	private List<Diagnosis> diagnosisList = new ArrayList<>();
	private HospIndex hospI = new HospIndex();
	private H3 errorT = new H3("Select a PatientCase first!");
	private Div error = new Div();
	private PatientCase patientCase;
	private Doctor doctor;

	/**
	 * Constructor generate the GUI.
	 */
	public ReportViewImpl() {
		// Execute after loading the page.
		this.addAttachListener(e -> {
			for (ReportViewListener listener : listeners) {
				if (VaadinSession.getCurrent().getAttribute("patientCaseID") != null) {
					listener.getAll(
							Integer.parseInt(VaadinSession.getCurrent().getAttribute("patientCaseID").toString()),
							Integer.parseInt(VaadinSession.getCurrent().getAttribute("patientID").toString()));
					listener.getDoctor(
							Integer.parseInt(VaadinSession.getCurrent().getAttribute("patientCaseID").toString()));
					listener.getPatientCaseList(
							Integer.parseInt(VaadinSession.getCurrent().getAttribute("patientID").toString()));
				}
			}
		});
		// Set patient and patient case information.
		if (VaadinSession.getCurrent().getAttribute("patientCaseID") != null) {
			patientFirstnameL.setText(VaadinSession.getCurrent().getAttribute("patientFirstname").toString());
			patientNameL.setText(VaadinSession.getCurrent().getAttribute("patientName").toString());
			patientCaseL.setText(VaadinSession.getCurrent().getAttribute("patientCaseID").toString());
		}

		// On click add new patient case.
		newB.addClickListener(e -> {
			for (ReportViewListener listener : listeners) {
				listener.getPatientCaseObject(
						Integer.parseInt(VaadinSession.getCurrent().getAttribute("patientCaseID").toString()));
				listener.getDoctorObject(
						Integer.parseInt(VaadinSession.getCurrent().getAttribute("doctorID").toString()));
				PatientCase pc = new PatientCase(patientCase.getPatient(), doctor);
				listener.addPatientCase(pc);
			}
		});

		// Consultation editor settings.
		consultationTA.setWidth("100%");
		// On change save
		consultationTA.addValueChangeListener(e -> {
			for (ReportViewListener listener : listeners) {
				listener.saveReport(
						Integer.parseInt(VaadinSession.getCurrent().getAttribute("patientCaseID").toString()),
						consultationTA.getValue());
			}
		});

		// Setup diagnosis Grid.
		diagnosisG.addColumn(Diagnosis::getDiagnosis).setHeader("Diagnosis");
		diagnosisG.setItems(diagnosisList);

		// On click add diagnose.
		addDiagnosisB.addClickListener(e -> {
			for (ReportViewListener listener : listeners) {
				if (!diagnosisT.getValue().equalsIgnoreCase("")) {
					listener.getPatientCaseObject(
							Integer.parseInt(VaadinSession.getCurrent().getAttribute("patientCaseID").toString()));
					listener.addDiagnosis(
							Integer.parseInt(VaadinSession.getCurrent().getAttribute("patientCaseID").toString()),
							new Diagnosis(patientCase, diagnosisT.getValue()));
					diagnosisG.getDataProvider().refreshAll();
					diagnosisT.setValue("");
				}
			}
		});

		// set header informations.
		doctorLayout.add(doctorI, doctorFirstnameL, doctorNameL);
		patientLayout.add(patientI, patientFirstnameL, patientNameL);
		patientCaseLayout.add(patientCaseI, patientCaseL);
		information.add(doctorLayout, patientLayout, patientCaseLayout);

		// set diagnose TextField settings.
		diagnosisT.setLabel("Diagnose");

		// fill ComboBox.
		this.combo.setItems("Ibuprofen 200mg", "Ibuprofen 400mg", "Ibuprofen 600mg");

		// Tabs settings.
		tabs.setFlexGrowForEnclosedTabs(1);
		tabs.setWidth("100%");

		// Build medication layout.
		layout2.add(combo, textfieldactiveIngredient, textfieldStrength, textfieldForm);
		layout3.add(textfieldMorning, textfieldNoon, textfieldEvening, textfieldAtBedtime);
		layout4.add(textfieldUnit, textfieldInstructions, textfieldIndication);

		// Change fields when input is changed.
		combo.addValueChangeListener(event -> {
			for (Drug drug : hospI.getDrugList()) {
				if (combo.getValue().equalsIgnoreCase(drug.getactiveIngridient())) {
					textfieldactiveIngredient.setValue(combo.getValue());
					textfieldbrandName.setValue(drug.getbrandName());
					textfieldStrength.setValue(drug.getstrength());
					textfieldAtBedtime.setValue("0");
					textfieldEvening.setValue("0");
					textfieldMorning.setValue("0");
					textfieldNoon.setValue("0");
					textfieldForm.setValue(drug.getform());
					textfieldUnit.setValue(drug.getUnit());
					textfieldInstructions.setValue(drug.getInstruction());
					textfieldIndication.setValue(drug.getIndication());
				}
			}
			textfieldactiveIngredient.setEnabled(false);
			textfieldStrength.setEnabled(false);
			textfieldForm.setEnabled(false);
			textfieldIndication.setEnabled(false);
			textfieldInstructions.setEnabled(false);
			textfieldUnit.setEnabled(false);
		});

		// Column set and description.
		medicationG.setItems(medicationList);
		medicationG.addColumn(Medication::getActiveIngredient).setHeader("Active Ingredient");
		medicationG.addColumn(Medication::getBrandName).setHeader("Brand name");
		medicationG.addColumn(Medication::getStrength).setHeader("Strength");
		medicationG.addColumn(Medication::getForm).setHeader("Form");
		medicationG.addColumn(Medication::getmorning).setHeader("morning");
		medicationG.addColumn(Medication::getnoon).setHeader("noon");
		medicationG.addColumn(Medication::getevening).setHeader("evening");
		medicationG.addColumn(Medication::getatBedtime).setHeader("at bedtime");
		medicationG.addColumn(Medication::getUnit).setHeader("Unit");
		medicationG.addColumn(Medication::getInstructions).setHeader("Instructions");
		medicationG.addColumn(Medication::getIndication).setHeader("Indication");

		// On click insert Medicationvalues in Grid.
		addMedicationB.addClickListener(e -> {
			for (ReportViewListener listener : listeners) {
				listener.getPatientCaseObject(
						Integer.parseInt(VaadinSession.getCurrent().getAttribute("patientCaseID").toString()));

				Medication medi = new Medication(combo.getValue(), textfieldactiveIngredient.getValue(),
						textfieldStrength.getValue(), textfieldForm.getValue(), textfieldMorning.getValue(),
						textfieldNoon.getValue(), textfieldEvening.getValue(), textfieldAtBedtime.getValue(),
						textfieldUnit.getValue(), textfieldInstructions.getValue(), textfieldIndication.getValue(),
						patientCase);
				listener.addMedication(
						Integer.parseInt(VaadinSession.getCurrent().getAttribute("patientCaseID").toString()), medi);
				medicationG.getDataProvider().refreshAll();

				textfieldactiveIngredient.clear();
				textfieldStrength.clear();
				textfieldForm.clear();
				textfieldIndication.clear();
				textfieldInstructions.clear();
				textfieldUnit.clear();
				textfieldMorning.clear();
				textfieldNoon.clear();
				textfieldEvening.clear();
				textfieldAtBedtime.clear();
				textfieldactiveIngredient.setEnabled(true);
				textfieldStrength.setEnabled(true);
				textfieldForm.setEnabled(true);
				textfieldIndication.setEnabled(true);
				textfieldInstructions.setEnabled(true);
				textfieldUnit.setEnabled(true);
				combo.clear();
			}
		});

		// On click remove selected medication.
		removeMedicationB.addClickListener(e -> {
			for (ReportViewListener listener : listeners) {
				List<Medication> list = new ArrayList<Medication>(medicationG.getSelectedItems());
				Medication medication = list.get(0);
				listener.removeMedication(
						Integer.parseInt(VaadinSession.getCurrent().getAttribute("patientCaseID").toString()),
						medication);
			}
		});

		// On click remove selected diagnose.
		removeDiagnosisB.addClickListener(e -> {
			for (ReportViewListener listener : listeners) {

				List<Diagnosis> list = new ArrayList<Diagnosis>(diagnosisG.getSelectedItems());
				Diagnosis diagnosis = list.get(0);
				listener.removeDiagnosis(
						Integer.parseInt(VaadinSession.getCurrent().getAttribute("patientCaseID").toString()),
						diagnosis);
			}
		});

		// On click delete patient case.
		deleteB.addClickListener(e -> {
			for (ReportViewListener listener : listeners) {
				listener.removePatientCase(
						Integer.parseInt(VaadinSession.getCurrent().getAttribute("patientCaseID").toString()));
				redirect();
			}
		});

		// Error Button.
		error.add(errorT);
		error.addClassName("sessionError");

		// Add to layout.
		if (VaadinSession.getCurrent().getAttribute("patientCaseID") == null) {
			root.add(error);
		} else {
			root.add(tabs, newB, information, consultationTA, diagnosisT, addDiagnosisB, diagnosisG, removeDiagnosisB,
					layout2, layout3, layout4, addMedicationB, medicationG, removeMedicationB, deleteB);
		}
		// Add root to content.
		super.content.add(root);

	}

	/**
	 * @param listeners add listeners.
	 * 
	 *                  Add listeners.
	 */
	@Override
	public void addListener(ReportViewListener listener) {
		listeners.add(listener);
	}

	/**
	 * @param patientCase get patientCase from presenter.
	 *
	 *                    Display doctor first and last name.
	 */
	@Override
	public void displayDoctor(PatientCase patientCase) {
		doctorFirstnameL.setText(patientCase.getDoctor().getFirstname());
		doctorNameL.setText(patientCase.getDoctor().getName());

	}

	/**
	 * @param patientCase get patient case from presenter.
	 * 
	 *                    Set all header information (first and last name of doctor
	 *                    and save patient case id in Session).
	 */
	@Override
	public void setSessionID(int patientCaseID) {
		VaadinSession.getCurrent().setAttribute("patientCaseID", patientCaseID);
	}

	/**
	 * @param consultation get consultation from presenter.
	 * 
	 *                     fill the consultation textarea with the consultation from
	 *                     patient case.
	 */
	@Override
	public void displayReport(String report) {
		consultationTA.setValue(report);
	}

	/**
	 * @param diagnosisList get diagnosisList from presenter.
	 * 
	 *                      fill the diagnosis grid with the diagnosis in the
	 *                      madicationList.
	 */
	@Override
	public void displayDiagnosisList(List<Diagnosis> diagnosisList) {
		diagnosisG.setItems(diagnosisList);
	}

	/**
	 * @param medicationList get medicationList form presenter.
	 * 
	 *                       fill the medication grid with the medication in the
	 *                       madicationList.
	 */
	@Override
	public void displayMedicationList(List<Medication> medicationList) {
		medicationG.setItems(medicationList);
	}

	/**
	 * @param patientCaseList get patientCaseList from presenter.
	 *
	 *                        remove all tabs and generate new tabs. Add a change
	 *                        tab listener to change the patient case.
	 */
	@Override
	public void displayRegister(List<PatientCase> patientCaseList) {
		tabs.removeAll();
		for (PatientCase p : patientCaseList) {
			Tab t = new Tab("C " + p.getDate());
			t.setId(Integer.toString(p.getPatientcaseID()));
			tabs.add(t);
			if (p.getPatientcaseID() == Integer
					.parseInt(VaadinSession.getCurrent().getAttribute("patientCaseID").toString())) {
				tabs.setSelectedTab(t);
			}
		}
		tabs.addSelectedChangeListener(e -> {
			Tab t = tabs.getSelectedTab();
			if (!VaadinSession.getCurrent().getAttribute("patientCaseID").toString()
					.equalsIgnoreCase(t.getId().toString().replaceAll("\\D+", ""))) {
				VaadinSession.getCurrent().setAttribute("patientCaseID", t.getId().toString().replaceAll("\\D+", ""));
				UI.getCurrent().getPage().reload();
			}
		});
	}

	/**
	 * @param patientCase get patientCase from presenter.
	 * 
	 *                    change the patient case in the class.
	 */
	@Override
	public void setPatientCase(PatientCase patientCase) {
		this.patientCase = patientCase;
	}

	/**
	 * @param doctor get doctor from presenter.
	 * 
	 *               change the doctor in the class.
	 */
	@Override
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	/**
	 * Refresh page.
	 */
	@Override
	public void refresh() {
		UI.getCurrent().getPage().reload();
	}

	/**
	 * Navigate to patient page.
	 */
	@Override
	public void redirect() {
		UI.getCurrent().navigate("Patient");
	}
}