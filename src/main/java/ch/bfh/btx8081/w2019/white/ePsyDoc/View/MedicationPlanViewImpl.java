package ch.bfh.btx8081.w2019.white.ePsyDoc.View;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.MedicationPlanModel;

@Route("Medication")
@PageTitle("Medication")
public class MedicationPlanViewImpl extends Div implements MedicationPlanView {
	private static final long serialVersionUID = 1L;
	private VerticalLayout root = new VerticalLayout();
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
	private Grid<MedicationPlanModel> grid = new Grid<MedicationPlanModel>();
	private Button btnOk = new Button(new Icon(VaadinIcon.PLUS));
	private ComboBox<String> combo = new ComboBox<String>("Active Ingredient");
	private List<MedicationPlanModel> medicationplan= new ArrayList<>();

	public MedicationPlanViewImpl() {
		// Build Layout
		layout2.add(combo, textfieldactiveIngredient, textfieldStrength, textfieldForm);
		layout3.add(textfieldMorning, textfieldNoon, textfieldEvening, textfieldAtBedtime);
		layout4.add(textfieldUnit, textfieldInstructions, textfieldIndication);

		// Fill ComboBox
		combo.setItems("Ibuprofen 100mg", "Ibuprofen 200mg");

		// Change of fields when input is changed
		combo.addValueChangeListener(event -> {
			if (combo.getValue() == "Ibuprofen 100mg") {
				textfieldactiveIngredient.setValue(combo.getValue());
				textfieldbrandName.setValue("Brufen 100mg");
				textfieldStrength.setValue("100 mg");
				textfieldForm.setValue("Tabl");
				textfieldIndication.setValue("Pain");
				textfieldInstructions.setValue("Take with a glas of water");
				textfieldUnit.setValue("Pcs");

				textfieldactiveIngredient.setEnabled(false);
				textfieldStrength.setEnabled(false);
				textfieldForm.setEnabled(false);
				textfieldIndication.setEnabled(false);
				textfieldInstructions.setEnabled(false);
				textfieldUnit.setEnabled(false);
			} else if (combo.getValue() == "Ibuprofen 200mg") {
				textfieldactiveIngredient.setValue(combo.getValue());
				textfieldbrandName.setValue("Brufen 200mg");
				textfieldStrength.setValue("200 mg");
				textfieldForm.setValue("Tabl");
				textfieldIndication.setValue("Pain");
				textfieldInstructions.setValue("Take with a glass of water");
				textfieldUnit.setValue("Pcs");
				
				textfieldactiveIngredient.setEnabled(false);
				textfieldStrength.setEnabled(false);
				textfieldForm.setEnabled(false);
				textfieldIndication.setEnabled(false);
				textfieldInstructions.setEnabled(false);
				textfieldUnit.setEnabled(false);
			}
		});
		
		// Column set and description
		grid.addColumn(MedicationPlanModel::getactiveIngredient).setHeader("Active Ingredient");
		grid.addColumn(MedicationPlanModel::getbrandName).setHeader("Brand name");
		grid.addColumn(MedicationPlanModel::getstrength).setHeader("Strength");
		grid.addColumn(MedicationPlanModel::getform).setHeader("Form");
		grid.addColumn(MedicationPlanModel::getmorning).setHeader("morning");
		grid.addColumn(MedicationPlanModel::getnoon).setHeader("noon");
		grid.addColumn(MedicationPlanModel::getevening).setHeader("evening");
		grid.addColumn(MedicationPlanModel::getatBedtime).setHeader("at bedtime");
		grid.addColumn(MedicationPlanModel::getunit).setHeader("Unit");
		grid.addColumn(MedicationPlanModel::getinstructions).setHeader("Instructions");
		grid.addColumn(MedicationPlanModel::getindication).setHeader("Indication");

		//Insert values in Grid
		btnOk.addClickListener(event -> {
			medicationplan.add(new MedicationPlanModel(combo.getValue(), textfieldactiveIngredient.getValue(),
					textfieldStrength.getValue(), textfieldForm.getValue(), textfieldMorning.getValue(),
					textfieldNoon.getValue(), textfieldEvening.getValue(), textfieldAtBedtime.getValue(),
					textfieldUnit.getValue(), textfieldInstructions.getValue(), textfieldIndication.getValue()));

			for (MedicationPlanModel plan : medicationplan) {

				if (plan.getmorning().isEmpty()) {
					plan.setmorning("0");
				}
				if (plan.getnoon().isEmpty()) {
					plan.setnoon("0");
				}
				if (plan.getevening().isEmpty()) {
					plan.setevening("0");
				}
				if (plan.getatBedtime().isEmpty()) {
					plan.setatBedtime("0");
				}
			}

			// Insert item
			grid.setItems(medicationplan);
			
			// Change field status
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
		});

		// Add to layout
		root.add(layout2, layout3, layout4, btnOk,grid);
		add(root);

	}


	@Override
	public void addListener(MedicationPlanViewListener listener) {
		// TODO Auto-generated method stub
		
	}
}
