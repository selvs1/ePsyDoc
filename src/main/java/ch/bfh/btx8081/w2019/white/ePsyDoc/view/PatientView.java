package ch.bfh.btx8081.w2019.white.ePsyDoc.view;

import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Patient;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.PatientCase;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.PatientModel;

import java.util.List;

public interface PatientView {
	interface PatientViewListener {		
		void onLoadPatientList();
		void loadPatientCaseList();
		void setPatientCaseList(int patientID);
	}

	
	void addListener(PatientViewListener listener);
	void displayPatientList(List<Patient> patientList);
	void displayPatientCaseList(List<PatientCase> patientCaseList);

	
}
