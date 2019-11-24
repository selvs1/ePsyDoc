package ch.bfh.btx8081.w2019.white.ePsyDoc;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("Jena")
@PageTitle("Patient")
public class jenasview extends VerticalLayout {
	
	HorizontalLayout vLayout = new HorizontalLayout();
	VerticalLayout hLayout = new VerticalLayout();
	TextField firstnameTextfield = new TextField("Vorname");
	TextField lastnameTextfield = new TextField("Nachname");
	Button PatientButton = new Button("Patient Searching");
	Button berichtButton = new Button("Bericht senden");
	Button homeback = new Button("home");
	private final Grid<CustomField> grid = new Grid<>();
	


	
	 public jenasview() {
		 
		 
	
		 
		// homePatient.add(patientScreen,patientScreen2);
		 
  
		 H1 header = new H1("ePsyDoc");
	        header.getElement().getThemeList().add("darkblue");
	        add(header); 
	        
	        TextArea area1 = new TextArea("Bericht schreiben");
	        area1.setValue("Viktor ist stabil Krank");

	        
	        
	        VerticalLayout hLayout1 = new VerticalLayout();
	        VerticalLayout hLayout2 = new VerticalLayout();
	        berichtButton.setEnabled(false);
			
			hLayout.add(firstnameTextfield,lastnameTextfield, PatientButton, homeback);
			hLayout1.add(grid);
			hLayout2.add(area1, berichtButton);
			

			vLayout.add(hLayout, hLayout1,hLayout2);
			this.add(vLayout);
	    } 
	 
	 
	
	 
	 
		 
	

	 
	 
    

}
