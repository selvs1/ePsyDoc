/**
 * This class contains the main view of the application. All patients of the day are displayed here. This allows the physician to access the consultations more quickly.
 *
 * @author Alain Nippel
 */
package ch.bfh.btx8081.w2019.white.ePsyDoc.view;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.server.VaadinSession;

import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Appointment;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.PatientCase;

//Route Name and Page Title

public class AppointmentViewImpl extends MainLayoutView implements AppointmentView {

	private static final long serialVersionUID = 1L;
	private LocalDate date = LocalDate.now();
	private VerticalLayout root = new VerticalLayout();
	private H1 title = new H1("Today's Patient");
	private DatePicker datePicker = new DatePicker();
	private Grid<Appointment> appointment = new Grid<>();
	private List<Appointment> appointmentList = new ArrayList<>();
	private Grid<PatientCase> patientCase = new Grid<>();
	private List<PatientCase> patientCaseList = new ArrayList<>();
	private List<AppointmentViewListener> listeners = new ArrayList<>();


	public AppointmentViewImpl() {

		
		// Load Data
		this.addAttachListener(e -> {
			for (AppointmentViewListener listener : listeners) {
				listener.loadAppointmentData(new Date(System.currentTimeMillis()));
			}
		});
		
		// datePicker settings
		datePicker.setValue(date);
		datePicker.addValueChangeListener(e -> {
			date = datePicker.getValue();
			for (AppointmentViewListener listener : listeners) {
				Date date2 = new Date(0,0,0).valueOf(date);
				listener.loadAppointmentData(date2);
				}
			appointment.getDataProvider().refreshAll();
		});

		appointment.setItems(appointmentList);
		
		// Column set and description
		appointment.addColumn(Appointment::getAppointmentID).setVisible(false);
		appointment.addColumn(Appointment::getPatientFirstname).setHeader("Firstname");
		appointment.addColumn(Appointment::getPatientLastname).setHeader("Lastname");
		appointment.addColumn(Appointment::getAppointmentTime).setHeader("Time");
		appointment.setItems(appointmentList);

		// Column set, description and settings
		patientCase.setVisible(false);

		appointment.addItemClickListener(event -> {
			VaadinSession.getCurrent().setAttribute("patientID", event.getItem().getPatient().getPatientID());
			VaadinSession.getCurrent().setAttribute("patientFirstname", event.getItem().getPatient().getFirstname());
			VaadinSession.getCurrent().setAttribute("patientName", event.getItem().getPatient().getLastname());
			VaadinSession.getCurrent().setAttribute("patientCaseID", "NULL");

			// Get PatienCase
			for (AppointmentViewListener listener : listeners) {
				listener.setPatientCaseList(event.getItem().getPatient().getPatientID());
			}

			// Update PatientCase Grid
			patientCase.setVisible(true);
			patientCase.getDataProvider().refreshAll();
		});

		// Add to layout
		root.add(title, datePicker, appointment, patientCase);
		super.content.add(root);
	}

	@Override
	public void addListener(AppointmentViewListener listener) {
		listeners.add(listener);
	}

	@Override
	public void displayAppointmentList(List<Appointment> appointmentList) {
		this.appointment.setItems(appointmentList);
	}

	@Override
	public void displayPatientCaseList(List<PatientCase> patientCaseList) {
		System.out.println(patientCaseList);
		patientCase.setItems(patientCaseList);
		patientCase.getDataProvider().refreshAll();
		System.out.println(patientCase.getElement().toString());
	}
}