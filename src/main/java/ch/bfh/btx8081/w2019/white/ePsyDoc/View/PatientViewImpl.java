package ch.bfh.btx8081.w2019.white.ePsyDoc.View;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("Patient")
@PageTitle("Patient")
public class PatientViewImpl extends MainLayoutView implements MedicationView{

	public PatientViewImpl() {
		
		
		VerticalLayout hLayout = new VerticalLayout();
		VerticalLayout vLayout = new VerticalLayout();
		TextField firstnameTextfield = new TextField("Firstname");
		TextField lastnameTextfield = new TextField("Lastname");
		Button PatientButton = new Button("Patient searching");
		HorizontalLayout hLayout1 = new HorizontalLayout();
        HorizontalLayout hLayout2 = new HorizontalLayout();
        Grid<Object> grid = new Grid<Object>();
        
		
		hLayout.add(firstnameTextfield,lastnameTextfield, PatientButton);
		vLayout.add(grid);
		
		vLayout.add(hLayout);
		vLayout.add(grid);
		
		
		
		super.content.add(vLayout);
		
		
	}
}
