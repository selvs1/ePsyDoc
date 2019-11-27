package ch.bfh.btx8081.w2019.white.ePsyDoc.View;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.MedicationPlan;

@Route("Medication")
@PageTitle("Medication")
public class MedicationViewImpl extends Div implements MedicationView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	VerticalLayout root = new VerticalLayout();
	HorizontalLayout layout2 = new HorizontalLayout();
	HorizontalLayout layout3 = new HorizontalLayout();
	HorizontalLayout layout4 = new HorizontalLayout();
	TextField textfieldactiveIngredient = new TextField("Active Ingredient");
	TextField textfieldbrandName = new TextField("Brand name");
	TextField textfieldStrength = new TextField("Strength");
	TextField textfieldForm = new TextField("Form");
	TextField textfieldMorning = new TextField("morning");
	TextField textfieldNoon = new TextField("noon");
	TextField textfieldEvening = new TextField("evening");
	TextField textfieldAtBedtime = new TextField("at bedtime");
	TextField textfieldUnit = new TextField("Unit");
	TextField textfieldInstructions = new TextField("Instructions");
	TextField textfieldIndication = new TextField("Indication");
	Grid<MedicationPlan> grid = new Grid<MedicationPlan>();
	Button btnOk = new Button("Confirm and add to medicationplan");
	ComboBox<String> combo = new ComboBox<String>("Active Ingredient");
	List<MedicationPlan> medicationplan;

	public MedicationViewImpl() {
		// Build Layout
		layout2.add(combo, textfieldactiveIngredient, textfieldStrength, textfieldForm);
		layout3.add(textfieldMorning, textfieldNoon, textfieldEvening, textfieldAtBedtime);
		layout4.add(textfieldUnit, textfieldInstructions, textfieldIndication);

		combo.setItems("Ibuprofen 100mg", "Ibuprofen 200mg");

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
			}
			else if(combo.getValue() == "Ibuprofen 200mg") {
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
	

		medicationplan = new ArrayList<>();
		grid = new Grid<>();
		grid.addColumn(MedicationPlan::getactiveIngredient).setHeader("Active Ingredient");
		grid.addColumn(MedicationPlan::getbrandName).setHeader("Brand name");
		grid.addColumn(MedicationPlan::getstrength).setHeader("Strength");
		grid.addColumn(MedicationPlan::getform).setHeader("Form");
		grid.addColumn(MedicationPlan::getmorning).setHeader("morning");
		grid.addColumn(MedicationPlan::getnoon).setHeader("noon");
		grid.addColumn(MedicationPlan::getevening).setHeader("evening");
		grid.addColumn(MedicationPlan::getatBedtime).setHeader("at bedtime");
		grid.addColumn(MedicationPlan::getunit).setHeader("Unit");
		grid.addColumn(MedicationPlan::getinstructions).setHeader("Instructions");
		grid.addColumn(MedicationPlan::getindication).setHeader("Indication");

		btnOk.addClickListener(event -> {

			medicationplan.add(new MedicationPlan(combo.getValue(), textfieldactiveIngredient.getValue(), textfieldStrength.getValue(), textfieldForm.getValue(), textfieldMorning.getValue(), textfieldNoon.getValue(), textfieldEvening.getValue(), textfieldAtBedtime.getValue(), textfieldUnit.getValue(), textfieldInstructions.getValue(), textfieldIndication.getValue()));

			for(MedicationPlan plan : medicationplan) {
				
				if(plan.getmorning().isEmpty()) {
					plan.setmorning("0");
				}if(plan.getnoon().isEmpty()) {
					plan.setnoon("0");
				}if(plan.getevening().isEmpty()) {
					plan.setevening("0");
				}if( plan.getatBedtime().isEmpty()) {
					plan.setatBedtime("0");
				}
			}
				
			grid.setItems(medicationplan);
			root.add(grid);

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

		root.add(layout2, layout3, layout4, btnOk);

		add(root);

	}
}
