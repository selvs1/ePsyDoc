package ch.bfh.btx8081.w2019.white.ePsyDoc.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
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

import ch.bfh.btx8081.w2019.white.ePsyDoc.model.Diagnosis;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.Drug;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.HospIndex;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.Medication;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.MedicationPlan;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.PatientCase;

public class ReportViewImpl extends MainLayoutView implements ReportView {
	private static final long serialVersionUID = 1L;
	private HorizontalLayout layout2 = new HorizontalLayout();
	private HorizontalLayout layout3 = new HorizontalLayout();
	private HorizontalLayout layout4 = new HorizontalLayout();
	private TextField textfieldactiveIngredient = new TextField("Active Ingredient");
	private TextField textfieldbrandName = new TextField("Brand name");
	private TextField textfieldStrength = new TextField("Strength");
	private TextField textfieldForm = new TextField("Form");
	private TextField textfieldMorning = new TextField("morning");
	private TextField textfieldNoon = new TextField("noon");
	private TextField textfieldEvening = new TextField("evening");
	private TextField textfieldAtBedtime = new TextField("at bedtime");
	private TextField textfieldUnit = new TextField("Unit");
	private TextField textfieldInstructions = new TextField("Instructions");
	private TextField textfieldIndication = new TextField("Indication");
	private Grid<Medication> medicationG = new Grid<Medication>();
	private Button btnOk = new Button(new Icon(VaadinIcon.PLUS));
	private ComboBox<String> combo = new ComboBox<String>("Active Ingredient");
	Date date = new Date();
	private Label l;
	private VerticalLayout root = new VerticalLayout();
	private Button newB = new Button(new Icon(VaadinIcon.FILE_ADD));
	private Button deleteB = new Button(new Icon(VaadinIcon.FILE_REMOVE));
	private Button addB = new Button(new Icon(VaadinIcon.PLUS));
	private TextField diagnosisT = new TextField();
	private Grid<Diagnosis> diagnosisG = new Grid<Diagnosis>();
	private VerticalLayout information = new VerticalLayout();
	private HorizontalLayout patientCaseLayout = new HorizontalLayout();
	private HorizontalLayout doctorLayout = new HorizontalLayout();
	private HorizontalLayout patientLayout = new HorizontalLayout();
	private Icon doctorI = new Icon(VaadinIcon.DOCTOR);
	private Icon patientI = new Icon(VaadinIcon.USER);
	private Icon patientCaseI = new Icon(VaadinIcon.CLIPBOARD_CROSS);
	private Label patientCaseL = new Label();
	private Label doctorFirstnameL = new Label();
	private Label doctorNameL = new Label();
	private Label patientFirstnameL = new Label();
	private Label patientNameL = new Label();
	private Tabs tabs = new Tabs();
	private TextArea consultation = new TextArea("Consultation");
	private List<ReportViewListener> listeners = new ArrayList<>();
	private List<Medication> medicationList = new ArrayList<>();
	private List<Diagnosis> diagnosisList = new ArrayList<>();
	HospIndex hospI = new HospIndex();

	public ReportViewImpl() {
		this.addAttachListener(e -> {
			for (ReportViewListener listener : listeners) {
				listener.getPatientData();
				listener.getDoctorData();
				listener.getPatientCaseID();
				listener.clickAddMedication(
						new Medication("Ibuprofen 600mg", "IBUPROFEN AL akut 600mg Film-coated-tablet", "", "", "", "",
								"600mg", "Film-coated-tablet", "Pcs", "Take with a glas of water", "Pain"));
			}

		});
		diagnosisG.addColumn(Diagnosis::getDiagnosis).setHeader("Diagnosis");
		diagnosisG.setItems(diagnosisList);
		// Diagnosis
		addB.addClickListener(e -> {
			Diagnosis diagnose = new Diagnosis(diagnosisT.getValue());
			diagnosisList.add(diagnose);
			diagnosisG.getDataProvider().refreshAll();

		});

		// consultation editor settings
		consultation.setWidth("100%");

		// set header informations
		doctorLayout.add(doctorI, doctorFirstnameL, doctorNameL);
		patientLayout.add(patientI, patientFirstnameL, patientNameL);
		patientCaseLayout.add(patientCaseI, patientCaseL);
		information.add(doctorLayout, patientLayout, patientCaseLayout);

		// set Grid header
		// set diagnose TextField settings
		diagnosisT.setLabel("Diagnose");

		// fill ComboBox

		this.combo.setItems("Ibuprofen 200mg", "Ibuprofen 400mg", "Ibuprofen 600mg");

		// Tabs settings
		tabs.setFlexGrowForEnclosedTabs(1);
		tabs.setWidth("100%");
		// Build Layout
		layout2.add(combo, textfieldactiveIngredient, textfieldStrength, textfieldForm);
		layout3.add(textfieldMorning, textfieldNoon, textfieldEvening, textfieldAtBedtime);
		layout4.add(textfieldUnit, textfieldInstructions, textfieldIndication);

		// Change of fields when input is changed
		combo.addValueChangeListener(event -> {
			for (Drug drug : hospI.getDrugList()) {
				if (combo.getValue().equalsIgnoreCase(drug.getactiveIngridient())) {
					textfieldactiveIngredient.setValue(combo.getValue());
					textfieldbrandName.setValue(drug.getbrandName());
					textfieldStrength.setValue(drug.getstrength());
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

		// Column set and description
		medicationG.setItems(medicationList);
		medicationG.addColumn(Medication::getactiveIngredient).setHeader("Active Ingredient");
		medicationG.addColumn(Medication::getbrandName).setHeader("Brand name");
		medicationG.addColumn(Medication::getstrength).setHeader("Strength");
		medicationG.addColumn(Medication::getform).setHeader("Form");
		medicationG.addColumn(Medication::getmorning).setHeader("morning");
		medicationG.addColumn(Medication::getnoon).setHeader("noon");
		medicationG.addColumn(Medication::getevening).setHeader("evening");
		medicationG.addColumn(Medication::getatBedtime).setHeader("at bedtime");
		medicationG.addColumn(Medication::getunit).setHeader("Unit");
		medicationG.addColumn(Medication::getinstructions).setHeader("Instructions");
		medicationG.addColumn(Medication::getindication).setHeader("Indication");

		// Insert values in Grid
		btnOk.addClickListener(e -> {
			for (ReportViewListener listener : listeners) {
				Medication medi = new Medication(combo.getValue(), textfieldactiveIngredient.getValue(),
						textfieldStrength.getValue(), textfieldForm.getValue(), textfieldMorning.getValue(),
						textfieldNoon.getValue(), textfieldEvening.getValue(), textfieldAtBedtime.getValue(),
						textfieldUnit.getValue(), textfieldInstructions.getValue(), textfieldIndication.getValue());
				
				Medication edi2 = new Medication("Ibuprofen 600mg", "IBUPROFEN AL akut 600mg Film-coated-tablet","","","","","600mg",
						"Film-coated-tablet","Pcs","Take with a glas of water","Pain");
				listener.clickAddMedication(edi2);
				medicationG.getDataProvider().refreshAll();
				
				

				//medicationList.add(medi);
				//medicationG.getDataProvider().refreshAll();
				// Change field status
				/*
				 * textfieldactiveIngredient.clear(); textfieldStrength.clear();
				 * textfieldForm.clear(); textfieldIndication.clear();
				 * textfieldInstructions.clear(); textfieldUnit.clear();
				 * textfieldMorning.clear(); textfieldNoon.clear(); textfieldEvening.clear();
				 * textfieldAtBedtime.clear(); textfieldactiveIngredient.setEnabled(true);
				 * textfieldStrength.setEnabled(true); textfieldForm.setEnabled(true);
				 * textfieldIndication.setEnabled(true); textfieldInstructions.setEnabled(true);
				 * textfieldUnit.setEnabled(true); combo.clear();
				 */
			}

		});

		root.add();

		l = new Label();
		// Add to layout
		root.add(l, tabs, newB, information, consultation, diagnosisT, addB, diagnosisG, layout2, layout3, layout4,
				btnOk, medicationG, deleteB);
		super.content.add(root);
	}

	@Override
	public void addListener(ReportViewListener listener) {
		listeners.add(listener);
	}

	@Override
	public void displayPatientCaseID(String patientCaseID) {
		patientCaseL.setText(patientCaseID);

	}

	@Override
	public void displayPatientCaseTabs(ArrayList<String> patientCaseIDs) {
		for (String id : patientCaseIDs) {
			this.tabs.add(new Tab(id));
		}

	}

	@Override
	public void displayDoctorName(String firstname, String name) {
		doctorFirstnameL.setText(firstname);
		doctorNameL.setText(name);

	}

	@Override
	public void displayPatientName(String firstname, String name) {
		patientFirstnameL.setText(firstname);
		patientNameL.setText(name);

	}

	@Override
	public void displayUpdateDiagnosisGrid(List<Diagnosis> diagnosis) {
		this.diagnosisList = diagnosis;
		this.diagnosisG.setItems(diagnosisList);
		this.diagnosisG.getDataProvider().refreshAll();
		

	}
	

	@Override
	public void displayUpdateMedicationGrid(MedicationPlan medication) {
		this.medicationList=medication.getMedicationPlan();
		l.setText(medication.getMedicationPlan().toString());
		this.medicationG.setItems(medicationList);
		this.medicationG.getDataProvider().refreshAll();
//todo: ferti machen
	}

	@Override
	public void displayPatientCase(PatientCase tempPatientCase) {
	//l.setText(tempPatientCase.getMedicationplan().getMedicationPlan().toString());
		
	}

}
