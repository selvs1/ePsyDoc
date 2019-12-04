/**
 * This class contains the main view of the application. All patients of the day are displayed here. This allows the physician to access the consultations more quickly.
 *
 * @author Alain Nippel
 */
package ch.bfh.btx8081.w2019.white.ePsyDoc.View;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.Patient;
import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.PatientCase;

//Route Name and Page Title

public class AppointmentViewImpl extends MainLayoutView implements AppointmentView {

	private static final long serialVersionUID = 1L;
	private LocalDate date = LocalDate.now();
	private VerticalLayout root = new VerticalLayout();
	private H1 title = new H1("Today's Patient");
	private DatePicker datePicker = new DatePicker();
	private Grid<Patient> patient = new Grid<>();
	private List<Patient> personList = new ArrayList<>();
	private Grid<PatientCase> patientCase = new Grid<>();
	private List<PatientCase> patientCaseList = new ArrayList<>();
	private List<AppointmentViewListener> listeners = new ArrayList<>();


	public AppointmentViewImpl() {

		// datePicker settings
		datePicker.setValue(date);
		datePicker.addValueChangeListener(e -> date = datePicker.getValue());

		// demo Data
		
		// Column set and description
		patient.addColumn(Patient::getPatientID).setHeader("Patient ID").setVisible(false);
		patient.addColumn(Patient::getFirstname).setHeader("Firstname");
		patient.addColumn(Patient::getLastname).setHeader("Lastname");
		patient.addColumn(Patient::getGender).setHeader("Gender");
		patient.addColumn(Patient::getDate).setHeader("Birthdate");
		patient.setItems(personList);

		// Column set, description and settings
		//patientCase.addColumn(PatientCase::getFid).setHeader("FID");
		patientCase.setVisible(false);
		patientCase.setItems(patientCaseList);

		// double click on patient item show patientCase Grid
		patient.addItemClickListener(e -> patientCase.setVisible(true));

		// Add to layout
		root.add(title, datePicker, patient, patientCase);
		super.content.add(root);
	}

	@Override
	public void addListener(AppointmentViewListener listener) {
		listeners.add(listener);

	}

	@Override
	public void showPatientCase() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void CalenderChange() {
		// TODO Auto-generated method stub
		
	}

}
