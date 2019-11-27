package ch.bfh.btx8081.w2019.white.ePsyDoc.View;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.Grid.Column;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.treegrid.TreeGrid;
import com.vaadin.flow.data.provider.hierarchy.TreeData;
import com.vaadin.flow.data.provider.hierarchy.TreeDataProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.Drug;
import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.PatientModel;

@Route("Appointment")
@PageTitle("Appointment")
public class AppointmentViewImpl extends MainLayoutView implements MedicationView {
private LocalDate date = LocalDate.now();
	public AppointmentViewImpl() {
		
		

		VerticalLayout root = new VerticalLayout();
		H1 title = new H1("Today's Patient");
		DatePicker datePicker = new DatePicker();
		datePicker.setValue(date);

				datePicker.addValueChangeListener(
		    e-> date = datePicker.getValue());
			List<PatientModel> personList = new ArrayList<>();

				personList.add(new PatientModel(1111, "Marley", "bla","dsf","sefs","sdf","cdsf"));
				personList.add(new PatientModel(2222, "Muster", "blo","dsf","sefs","sdf","cdsf"));
				personList.add(new PatientModel(3333, "Hauds", "blu","dsf","sefs","sdf","cdsf"));
			

				Grid<PatientModel> patient = new Grid<>(PatientModel.class);
				patient.setItems(personList);

				patient.removeColumnByKey("patientID");

				// The Grid<>(Person.class) sorts the properties and in order to
				// reorder the properties we use the 'setColumns' method.
				patient.setColumns("vorname", "name", "date","geschlecht");
				
				Grid<PatientModel> patientCase = new Grid<>(PatientModel.class);
				patientCase.setItems(personList);

				patientCase.removeColumnByKey("patientID");

				// The Grid<>(Person.class) sorts the properties and in order to
				// reorder the properties we use the 'setColumns' method.
				patientCase.setColumns("vorname", "name", "date","geschlecht");
		
		root.add(title, datePicker, patient);
		content.add(root);
		
	}


	
}
