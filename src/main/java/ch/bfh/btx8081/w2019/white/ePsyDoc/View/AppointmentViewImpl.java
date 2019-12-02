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
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.PatientCase;
import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.PatientModel;
import ch.bfh.btx8081.w2019.white.ePsyDoc.View.LoginView.LoginViewListener;

//Route Name and Page Title
@Route("Appointment")
@PageTitle("Appointment")
public class AppointmentViewImpl extends MainLayoutView implements AppointmentView {

	private static final long serialVersionUID = 1L;
	private LocalDate date = LocalDate.now();
	private VerticalLayout root = new VerticalLayout();
	private H1 title = new H1("Today's Patient");
	private DatePicker datePicker = new DatePicker();
	private Grid<PatientModel> patient = new Grid<>();
	private List<PatientModel> personList = new ArrayList<>();
	private Grid<PatientCase> patientCase = new Grid<>();
	private List<PatientCase> patientCaseList = new ArrayList<>();
	private List<AppointmentViewListener> listeners = new ArrayList<>();


	public AppointmentViewImpl() {
		// datePicker settings
		datePicker.setValue(date);
		datePicker.addValueChangeListener(e -> date = datePicker.getValue());

		// demo Data
		personList.add(new PatientModel(1, "Velkova", "Sugulina", "w", "12.12.1992", "Normalstrasse 43", "3000"));
		personList.add(new PatientModel(2, "Mars", "Jardon", "m", "10.02.1995", "Teststrasse 43", "3012"));
		personList.add(new PatientModel(3, "Jackson", "Peter", "m", "03.03.2000", "okstrasse 34", "3000"));
		personList.add(new PatientModel(4, "Bolliga", "Anna", "w", "12.06.1989", "strassstrasse 99", "3430"));

		patientCaseList.add(new PatientCase("F124134", personList, personList, null));
		patientCaseList.add(new PatientCase("F13423234", personList, personList, null));
		patientCaseList.add(new PatientCase("F898767", personList, personList, null));

		// Column set and description
		patient.addColumn(PatientModel::getPatientID).setHeader("Patient ID").setVisible(false);
		patient.addColumn(PatientModel::getFirstname).setHeader("Firstname");
		patient.addColumn(PatientModel::getLastname).setHeader("Lastname");
		patient.addColumn(PatientModel::getGender).setHeader("Gender");
		patient.addColumn(PatientModel::getDate).setHeader("Birthdate");
		patient.setItems(personList);

		// Column set, description and settings
		patientCase.addColumn(PatientCase::getFid).setHeader("FID");
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

}
