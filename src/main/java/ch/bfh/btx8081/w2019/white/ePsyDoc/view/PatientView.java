package ch.bfh.btx8081.w2019.white.ePsyDoc.view;

import java.util.List;

import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Patient;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.PatientCase;

public interface PatientView {
	interface PatientViewListener {
		void loadPatientList();

		void loadPatientCaseList();

		void setPatientCaseList(int patientID);
	}

	void addListener(PatientViewListener listener);

	void displayPatientList(List<Patient> patientList);

	void displayPatientCaseList(List<PatientCase> patientCaseList);
}