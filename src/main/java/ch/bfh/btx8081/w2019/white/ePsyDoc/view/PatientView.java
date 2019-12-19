package ch.bfh.btx8081.w2019.white.ePsyDoc.view;

import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Patient;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.PatientModel;

import java.util.List;

public interface PatientView {
	interface PatientViewListener {		
		void clickGetPatientName(PatientModel patient);
		void clickGetPatientID(PatientModel patient);

		void onLoadPatientList();

		void onPatientItemClicked(Patient choosedPatient);
	}

	void addListener(PatientViewListener listener);
	void displayPatientData(PatientModel patientModel);
	void displayPatientCaseData(PatientModel patientModel);
	void setPatientList(List<Patient> patientList);

	
}
