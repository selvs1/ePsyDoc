package ch.bfh.btx8081.w2019.white.ePsyDoc.view;

import java.sql.Date;
import java.util.List;

import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Appointment;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.PatientCase;

public interface AppointmentView {
	interface AppointmentViewListener {
		void loadAppointmentData(Date date);

		void setPatientCaseList(int patientID);
	}

	void addListener(AppointmentViewListener listener);

	void displayAppointmentList(List<Appointment> appointmentList);

	void displayPatientCaseList(List<PatientCase> patientCaseList);
}
