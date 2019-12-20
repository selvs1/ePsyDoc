package ch.bfh.btx8081.w2019.white.ePsyDoc.view;

import java.util.ArrayList;
import java.util.Date;
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

import ch.bfh.btx8081.w2019.white.ePsyDoc.MainView;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.HospIndex;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Diagnosis;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Doctor;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Drug;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Medication;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.PatientCase;

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
	private Button addMedicationB = new Button(new Icon(VaadinIcon.PLUS));
	private Button removeMedicationB = new Button(new Icon(VaadinIcon.MINUS));
	private ComboBox<String> combo = new ComboBox<String>("Active Ingredient");
	Date date = new Date();
	private VerticalLayout root = new VerticalLayout();
	private Button newB = new Button(new Icon(VaadinIcon.FILE_ADD));
	private Button deleteB = new Button(new Icon(VaadinIcon.FILE_REMOVE));
	private Button addDiagnosisB = new Button(new Icon(VaadinIcon.PLUS));
	private Button removeDiagnosisB = new Button(new Icon(VaadinIcon.MINUS));
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
	private H3 errorT = new H3("Select a PatientCase first!");
	private Div error = new Div();

	public ReportViewImpl() {
	
		this.addAttachListener(e -> {
			for (ReportViewListener listener : listeners) {
				if (VaadinSession.getCurrent().getAttribute("patientCaseID") != null) {
				listener.getDoctor(
						Integer.parseInt(VaadinSession.getCurrent().getAttribute("patientCaseID").toString()));
				listener.getPatientCaseList(Integer.parseInt(VaadinSession.getCurrent().getAttribute("patientID").toString()));
				}
			}

		});
		/*
		tabs.addSelectedChangeListener(e->{
			String[] tab = e.getSelectedTab().getElement().getText().split(" ");
			if(!VaadinSession.getCurrent().getAttribute("patientCaseID").toString().equalsIgnoreCase(tab[1])){
				VaadinSession.getCurrent().setAttribute("patientCaseID", tab[1]);
				
				 UI.getCurrent().getPage().reload();
			}
			
		});*/
		
		
		diagnosisG.addColumn(Diagnosis::getDiagnosis).setHeader("Diagnosis");
		diagnosisG.setItems(diagnosisList);
		// Diagnosis
		addDiagnosisB.addClickListener(e -> {
			for (ReportViewListener listener : listeners) {
				Diagnosis diagnose = new Diagnosis(diagnosisT.getValue());
				diagnosisG.getDataProvider().refreshAll();

			}
		});

		// consultation editor settings
		consultation.setWidth("100%");
		if (VaadinSession.getCurrent().getAttribute("patientCaseID") != null) {
			patientFirstnameL.setText(VaadinSession.getCurrent().getAttribute("patientFirstname").toString());
			patientNameL.setText(VaadinSession.getCurrent().getAttribute("patientName").toString());
			patientCaseL.setText(VaadinSession.getCurrent().getAttribute("patientCaseID").toString());
		}

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
		addMedicationB.addClickListener(e -> {
			for (ReportViewListener listener : listeners) {
				Medication medi = new Medication(combo.getValue(), textfieldactiveIngredient.getValue(),
						textfieldStrength.getValue(), textfieldForm.getValue(), textfieldMorning.getValue(),
						textfieldNoon.getValue(), textfieldEvening.getValue(), textfieldAtBedtime.getValue(),
						textfieldUnit.getValue(), textfieldInstructions.getValue(), textfieldIndication.getValue());
				listener.createMedication(Integer.parseInt(VaadinSession.getCurrent().getAttribute("patientCaseID").toString()),medi);
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

		// Error button
		error.add(errorT);
		error.addClassName("sessionError");

		// Add to layout
		if (VaadinSession.getCurrent().getAttribute("patientCaseID") == null) {
			root.add(error);
		} else {
			root.add(tabs, newB, information, consultation, diagnosisT, addDiagnosisB, diagnosisG,removeDiagnosisB, layout2, layout3, layout4,
					addMedicationB, medicationG,removeMedicationB, deleteB);
		}
		super.content.add(root);
	}

	@Override
	public void addListener(ReportViewListener listener) {
		listeners.add(listener);
	}

	@Override
	public void displayDoctor(PatientCase patientCase) {
		doctorFirstnameL.setText(patientCase.getDoctor().getFirstname());
		doctorNameL.setText(patientCase.getDoctor().getName());

	}

	@Override
	public void updateAll(List<PatientCase> patientCaseList, PatientCase patientCase,List<Diagnosis> diagnosis, List<Medication> medication) {
		doctorFirstnameL.setText(patientCase.getDoctor().getFirstname());
		doctorNameL.setText(patientCase.getDoctor().getName());
		consultation.setValue(patientCase.getReport().getReport());
		diagnosisG.setItems(diagnosis);
		medicationG.setItems(medication);
	}

	@Override
	public void displayDiagnosisList(List<Diagnosis> diagnosis) {
		diagnosisG.setItems(diagnosis);

	}

	@Override
	public void displayMedicationList(List<Medication> medication) {
		medicationG.setItems(medication);

	}

	@Override
	public void displayRegister(List<PatientCase> patientCase) {
		tabs.removeAll();
		for(PatientCase p : patientCase){
			Tab t = new Tab("C " + p.getPatientcaseID());
			tabs.add(t);
			if(p.getPatientcaseID()== Integer.parseInt(VaadinSession.getCurrent().getAttribute("patientCaseID").toString())) {
				tabs.setSelectedTab(t);
			}
		}
		
	}

	@Override
	public void changeRegister() {
		// TODO Auto-generated method stub

	}
}