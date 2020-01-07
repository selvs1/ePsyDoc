package ch.bfh.btx8081.w2019.white.ePsyDoc.view;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.server.VaadinSession;

import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Appointment;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Doctor;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Patient;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.PatientCase;

/**
 * @author Alain Nippel
 * @author Apiwat-David Gaupp
 * @author Janahan Sellathurai
 * @author Marko Miletic
 * @author Sugeelan Selvasingham
 * @author Viktor Velkov
 * 
 * @version 1.0
 * 
 *          Setup appointment GUI
 */
public class AppointmentViewImpl extends MainLayoutView implements AppointmentView {

	private static final long serialVersionUID = 1L;
	private LocalDate date = LocalDate.now();
	private VerticalLayout root = new VerticalLayout();
	private H1 title = new H1("Today's Patient");
	private Button newB = new Button(new Icon(VaadinIcon.FILE_ADD));
	private DatePicker datePicker = new DatePicker();
	private Grid<Appointment> appointmentG = new Grid<>();
	private Grid<PatientCase> patientCaseG = new Grid<>();
	private List<AppointmentViewListener> listeners = new ArrayList<>();
	private Doctor doctor;
	private Patient patient;

	public AppointmentViewImpl() {

		// Load Data
		this.addAttachListener(e -> {
			for (AppointmentViewListener listener : listeners) {
				listener.loadAppointmentData(new Date(System.currentTimeMillis()));
			}
		});
		
		// DatePicker settings
		datePicker.setValue(date);
		
		// Change date 
		datePicker.addValueChangeListener(e -> {
			date = datePicker.getValue();
			for (AppointmentViewListener listener : listeners) {
				Date date2 = new Date(0,0,0).valueOf(date);
				listener.loadAppointmentData(date2);
				}
			appointmentG.getDataProvider().refreshAll();
		});
		
		// PatientCase Grid setup
		patientCaseG.addColumn(PatientCase::getDate).setHeader("Patient Case");
		patientCaseG.addColumn(PatientCase::getPatientcaseID).setVisible(false);
		
		// Column set and description
		appointmentG.addColumn(Appointment::getAppointmentID).setVisible(false);
		appointmentG.addColumn(Appointment::getPatientFirstname).setHeader("Firstname");
		appointmentG.addColumn(Appointment::getPatientLastname).setHeader("Lastname");
		appointmentG.addColumn(Appointment::getAppointmentTime).setHeader("Time");

		// Column set, description and settings
		patientCaseG.setVisible(false);

		appointmentG.addItemClickListener(event -> {
			VaadinSession.getCurrent().setAttribute("patientID", event.getItem().getPatient().getPatientID());
			VaadinSession.getCurrent().setAttribute("patientFirstname", event.getItem().getPatient().getFirstname());
			VaadinSession.getCurrent().setAttribute("patientName", event.getItem().getPatient().getLastname());
			VaadinSession.getCurrent().setAttribute("patientCaseID", null);

			// Get PatienCase
			for (AppointmentViewListener listener : listeners) {
				listener.setPatientCaseList(event.getItem().getPatient().getPatientID());
			}

			// Update PatientCase Grid
			patientCaseG.setVisible(true);
			newB.setVisible(true);
			patientCaseG.getDataProvider().refreshAll();
		});
		
		// Click listener PatientCase
		patientCaseG.addItemClickListener(event -> {
			VaadinSession.getCurrent().setAttribute("patientCaseID", event.getItem().getPatientcaseID());
			UI.getCurrent().navigate("Report");
		});
		
		newB.setVisible(false);
		newB.addClickListener(e -> {
			for (AppointmentViewListener listener : listeners) {
				listener.getPatientObject(
						Integer.parseInt(VaadinSession.getCurrent().getAttribute("patientID").toString()));
				listener.getDoctorObject(
						Integer.parseInt(VaadinSession.getCurrent().getAttribute("doctorID").toString()));
				PatientCase pc = new PatientCase(patient, doctor);
				listener.addPatientCase(pc,Integer.parseInt(VaadinSession.getCurrent().getAttribute("patientID").toString()));
			}
		});

		root.add(title, datePicker, appointmentG, patientCaseG,newB);
		super.content.add(root);
	}

	@Override
	public void addListener(AppointmentViewListener listener) {
		listeners.add(listener);
	}

	@Override
	public void displayAppointmentList(List<Appointment> appointmentList) {
		this.appointmentG.setItems(appointmentList);
	}

	@Override
	public void displayPatientCaseList(List<PatientCase> patientCaseList) {
		patientCaseG.setItems(patientCaseList);
	}

	@Override
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;

	}

	@Override
	public void setPatient(Patient patient) {
		this.patient=patient;
		
	}
}