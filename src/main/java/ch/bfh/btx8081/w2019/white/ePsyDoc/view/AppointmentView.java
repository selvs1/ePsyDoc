package ch.bfh.btx8081.w2019.white.ePsyDoc.view;

import java.sql.Date;
import java.util.List;

import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Appointment;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Doctor;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Patient;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.PatientCase;

/**
 * AppointmentView interface contains all functions which are adopted in the
 * AppointmentViewListener class. The Interface AppointmentViewListener contains
 * all functions which are adopted in the AppointmentModel class.
 * 
 * @author Alain Nippel
 * @author Apiwat-David Gaupp
 * @author Janahan Sellathurai
 * @author Marko Miletic
 * @author Sugeelan Selvasingham
 * @author Viktor Velkov
 * 
 * @version 1.0
 */
public interface AppointmentView {
	interface AppointmentViewListener {
		void loadAppointmentData(Date date);

		void setPatientCaseList(int patientID);

		void getDoctorObject(int parseID);

		void getPatientObject(int patientID);

		void addPatientCase(PatientCase patientCase, int patientID);
	}

	void addListener(AppointmentViewListener listener);

	void displayAppointmentList(List<Appointment> appointmentList);

	void displayPatientCaseList(List<PatientCase> patientCaseList);

	void setDoctor(Doctor doctor);

	void setPatient(Patient patient);
}
