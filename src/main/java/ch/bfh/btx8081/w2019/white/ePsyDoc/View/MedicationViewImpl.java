package ch.bfh.btx8081.w2019.white.ePsyDoc.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.HospIndex;
import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.Medicationplan;
import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.Drug;

@Route("Medication")
@PageTitle("Medication")
public class MedicationViewImpl extends MainLayoutView implements MedicationView {

	VerticalLayout layout1 = new VerticalLayout();
	HorizontalLayout layout2 = new HorizontalLayout();
	HorizontalLayout layout3 = new HorizontalLayout();
	HorizontalLayout layout4 = new HorizontalLayout();
	TextField textfieldHandelsname = new TextField("Handelsname");
	TextField textfieldStärke = new TextField("Stärke");
	TextField textfieldForm = new TextField("Form");
	TextField textfieldMorgen = new TextField("morgen");
	TextField textfieldMittag = new TextField("mittag");
	TextField textfieldAbend = new TextField("abend");
	TextField textfieldNacht = new TextField("nacht");
	TextField textfieldEinheit = new TextField("Einheit");
	TextField textfieldHinweis = new TextField("Hinweis");
	TextField textfieldGrund = new TextField("Grund");
	Grid<Medicationplan> grid = new Grid<Medicationplan>();
	Button btnOk = new Button("OK");
	ComboBox<String> combo = new ComboBox<String>("Wirkstoff");
	List<Medicationplan> medicationplan;

	public MedicationViewImpl() {
		// Build Layout
		layout2.add(combo, textfieldHandelsname, textfieldStärke, textfieldForm);
		layout3.add(textfieldMorgen, textfieldMittag, textfieldAbend, textfieldNacht);
		layout4.add(textfieldEinheit, textfieldHinweis, textfieldGrund);

		combo.setItems("Ibuprofen 100mg", "Ibuprofen 200mg");

		combo.addValueChangeListener(event -> {
			if (combo.getValue() == "Ibuprofen 100mg") {
				textfieldHandelsname.setValue("Brufen 100mg");
				textfieldStärke.setValue("100 mg");
				textfieldForm.setValue("Tablette");
				textfieldGrund.setValue("Schmerzen");
				textfieldHinweis.setValue("Keine Hinweise");
				textfieldEinheit.setValue("Stück");

				textfieldHandelsname.setEnabled(false);
				textfieldStärke.setEnabled(false);
				textfieldForm.setEnabled(false);
				textfieldGrund.setEnabled(false);
				textfieldHinweis.setEnabled(false);
				textfieldEinheit.setEnabled(false);
			}
			else if(combo.getValue() == "Ibuprofen 200mg") {
				textfieldHandelsname.setValue("Brufen 200mg");
				textfieldStärke.setValue("200 mg");
				textfieldForm.setValue("Tablette");
				textfieldGrund.setValue("Schmerzen");
				textfieldHinweis.setValue("Keine Hinweise");
				textfieldEinheit.setValue("Stück");

				textfieldHandelsname.setEnabled(false);
				textfieldStärke.setEnabled(false);
				textfieldForm.setEnabled(false);
				textfieldGrund.setEnabled(false);
				textfieldHinweis.setEnabled(false);
				textfieldEinheit.setEnabled(false);
			}
		});
		
		medicationplan = new ArrayList<>();
		grid = new Grid<>();
		grid.addColumn(Medicationplan::getWirkstoffname).setHeader("Wirkstoffname");
		grid.addColumn(Medicationplan::getHandelsname).setHeader("Handelsname");
		grid.addColumn(Medicationplan::getStärke).setHeader("Stärke");
		grid.addColumn(Medicationplan::getForm).setHeader("Form");
		grid.addColumn(Medicationplan::getMorgen).setHeader("Morgen");
		grid.addColumn(Medicationplan::getMittag).setHeader("Mittag");
		grid.addColumn(Medicationplan::getAbend).setHeader("Abend");
		grid.addColumn(Medicationplan::getNacht).setHeader("Nacht");
		grid.addColumn(Medicationplan::getEinheit).setHeader("Einheit");
		grid.addColumn(Medicationplan::getHinweis).setHeader("Hinweis");
		grid.addColumn(Medicationplan::getGrund).setHeader("Grund");

		btnOk.addClickListener(event -> {

			medicationplan.add(new Medicationplan(combo.getValue(), textfieldHandelsname.getValue(), textfieldStärke.getValue(), textfieldForm.getValue(), textfieldMorgen.getValue(), textfieldMittag.getValue(), textfieldAbend.getValue(), textfieldNacht.getValue(), textfieldEinheit.getValue(), textfieldHinweis.getValue(), textfieldGrund.getValue()));

			grid.setItems(medicationplan);
			layout1.add(grid);

			textfieldHandelsname.clear();
			textfieldStärke.clear();
			textfieldForm.clear();
			textfieldGrund.clear();
			textfieldHinweis.clear();
			textfieldEinheit.clear();
			textfieldMorgen.clear();
			textfieldMittag.clear();
			textfieldAbend.clear();
			textfieldNacht.clear();
			textfieldHandelsname.setEnabled(true);
			textfieldStärke.setEnabled(true);
			textfieldForm.setEnabled(true);
			textfieldGrund.setEnabled(true);
			textfieldHinweis.setEnabled(true);
			textfieldEinheit.setEnabled(true);
			combo.clear();

		});

		layout1.add(layout2, layout3, layout4, btnOk);

		super.content.add(layout1);

	}

	public ArrayList<String> fillcombobox() {

		ArrayList<String> selection = new ArrayList<String>();

		for (Drug drug : HospIndex.druglist) {
			selection.add(drug.getWirkstoffname());

		}
		return selection;
	}

}
