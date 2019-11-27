package ch.bfh.btx8081.w2019.white.ePsyDoc.View;

import java.util.ArrayList;
import java.util.List;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.PatientModel;

@Route("Patient")
@PageTitle("Patient")
public class PatientViewImpl extends MainLayoutView implements MedicationView{

	public PatientViewImpl() {
		
		
		VerticalLayout hLayout = new VerticalLayout();
		VerticalLayout hLayout2 = new VerticalLayout();
		VerticalLayout vLayout = new VerticalLayout();
		TextField firstnameTextfield = new TextField("Firstname");
		TextField lastnameTextfield = new TextField("Lastname");
		Button btnPatientsearch = new Button("searching patient");
		Button btnPatientAll = new Button("all patient");
    	List<PatientModel> Patientlist = new ArrayList<PatientModel>();
   
    	
      
        
        
        //Testdaten
        Patientlist.add(new PatientModel(1, "Velkova", "Sugulina", "w", "12.12.1992", "Normalstrasse 43", "3000"));
        Patientlist.add(new PatientModel(2, "Mars", "Jardon", "m", "10.02.1995", "Teststrasse 43", "3012"));
        Patientlist.add(new PatientModel(3, "Jackson", "Peter", "m", "03.03.2000", "okstrasse 34", "3000"));
        Patientlist.add(new PatientModel(4, "Bolliga", "Anna", "w", "12.06.1989", "strassstrasse 99", "3430"));

        
		Grid<PatientModel> grid= new Grid<>();
		
		grid.addColumn(PatientModel::getPatientID).setHeader("Patient ID");
		grid.addColumn(PatientModel::getFirstname).setHeader("Firstname");
		grid.addColumn(PatientModel::getLastname).setHeader("Lastname");
		grid.addColumn(PatientModel::getGender).setHeader("Gender");
		grid.addColumn(PatientModel::getDate).setHeader("Birthdate");
		grid.addColumn(PatientModel::getAdress).setHeader("Address");
		grid.addColumn(PatientModel::getPlz).setHeader("PLZ");

		
	
		btnPatientAll.addClickListener(event -> {
			grid.setItems(Patientlist);
		});
		
		
		btnPatientsearch.addClickListener(event -> {
			
			firstnameTextfield.getValue();
			String nachname = lastnameTextfield.getValue();
			String vorname = firstnameTextfield.getValue();
			
			
			
			ArrayList<PatientModel> certain = new ArrayList<PatientModel>();

			for(PatientModel patient : Patientlist) {
				
				if(patient.getFirstname().equalsIgnoreCase(vorname) && patient.getLastname().equalsIgnoreCase(nachname)) {
		
					certain.add(patient);
				}
				grid.setItems(certain);
				
			}
	
		
		});
		
		

		
		
		
		
		
		
		
		
		hLayout.add(firstnameTextfield,lastnameTextfield, btnPatientsearch, grid);
		hLayout2.add(btnPatientAll);
		//vLayout.add(grid);
		vLayout.add(hLayout,hLayout2);
		//vLayout.add(grid);
		
		
		
		super.content.add(vLayout);
		
		
	}
	
}
