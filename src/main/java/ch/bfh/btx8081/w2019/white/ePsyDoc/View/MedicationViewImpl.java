package ch.bfh.btx8081.w2019.white.ePsyDoc.View;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.w2019.white.ePsyDoc.MainView;

@Route("Medication")
@PageTitle("Medication")
public class MedicationViewImpl extends MainLayoutView implements MedicationView{

	VerticalLayout layout1 = new VerticalLayout();
	HorizontalLayout layout2 = new HorizontalLayout();
	TextField textfieldWirkstoff = new TextField("Wirkstoff");
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
	Grid<Object> grid = new Grid<Object>();
	
	public MedicationViewImpl() {
		
		layout2.add(textfieldWirkstoff, textfieldHandelsname, textfieldStärke,
				textfieldForm, textfieldMorgen, textfieldMittag, textfieldAbend,
				textfieldNacht, textfieldEinheit, textfieldHinweis, textfieldGrund);
		
		layout1.add(layout2);
		layout1.add(grid);
		super.content.add(layout1);
		
	}
	

}
