package ch.bfh.btx8081.w2019.white.ePsyDoc.View;

import java.util.ArrayList;

import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.Doctor;
import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.PatientCase;
import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.PatientModel;

public interface PatientView {
	interface PatientViewListener {
		
		void clickNewPatientModel(int patientID, String lastname, String firstname, String gender, String date, String adress,
				String zip, ArrayList<PatientCase> patientCaseList);

	}

	void addListener(PatientViewListener listener);
}
