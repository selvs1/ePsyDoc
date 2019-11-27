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
import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.MedicationPlan;
import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.PatientCase;
import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.PatientModel;

@Route("Appointment")
@PageTitle("Appointment")
public class AppointmentViewImpl extends MainLayoutView implements MedicationView {
	private LocalDate date = LocalDate.now();
	private VerticalLayout root = new VerticalLayout();
	private H1 title = new H1("Today's Patient");
	private DatePicker datePicker = new DatePicker();
	private Grid<PatientModel> patient = new Grid<>(PatientModel.class);
	private List<PatientModel> personList = new ArrayList<>();
	private Grid<PatientCase> patientCase = new Grid<>(PatientCase.class);
	private List<PatientCase> patientCaseList = new ArrayList<>();

	public AppointmentViewImpl() {
		datePicker.setValue(date);
		datePicker.addValueChangeListener(e -> date = datePicker.getValue());
		patient.setItems(personList);
		patient.removeColumnByKey("patientID");
		patient.setColumns("firstname", "lastname", "date", "gender");
		patientCase.setColumns("fid");
		patientCase.setVisible(false);
		patientCase.setItems(patientCaseList);
		patient.addItemClickListener(e -> patientCase.setVisible(true));

		personList.add(new PatientModel(1111, "Marley", "bla", "dsf", "sefs", "sdf", "cdsf"));
		personList.add(new PatientModel(2222, "Muster", "blo", "dsf", "sefs", "sdf", "cdsf"));
		personList.add(new PatientModel(3333, "Hauds", "blu", "dsf", "sefs", "sdf", "cdsf"));

		patientCaseList.add(new PatientCase("F124134", personList, personList, null));
		patientCaseList.add(new PatientCase("F13423234", personList, personList, null));
		patientCaseList.add(new PatientCase("F898767", personList, personList, null));

		root.add(title, datePicker, patient, patientCase);
		super.content.add(root);
	}

}
