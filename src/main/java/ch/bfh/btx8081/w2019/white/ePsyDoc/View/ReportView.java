package ch.bfh.btx8081.w2019.white.ePsyDoc.View;

import java.util.ArrayList;

import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.Doctor;
import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.HospIndex;
import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.Medication;
import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.PatientCase;
import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.PatientModel;

public interface ReportView {

	interface ReportViewListener {
		// All
		void save(int intervall);

		void clickSetFields(PatientCase patientcase);

		void getModel(PatientModel patientModel);

		// Report
		void clickNewReport(Doctor doctor, PatientModel patient);

		void clickNewPatientCase(int patientCaseID, int patientID);

		void clickDeletePatientCase();

		void deleteDiagnose();

		// Medication
		void clickSetMedicationPlan(int patientcaseID, int patientID);

		void clickDisableFields();

		void clickAutofill();

		void clickAddMedication(Medication medication);

		void clickRemoveFromMedicationPlan(String brandname);

	}

	void addListener(ReportViewListener listener);

	// Report
	void displayPatientCaseTabs(ArrayList<String> patientCaseIDs);

	void displayDoctorName(String firstname, String name);
	

	void displayPatientName(String firstname, String name);

	void displayPatientCaseID(int patientCaseID);
	
	void displayUpdateDiagnosisGrid(ArrayList<String> diagnosis);

	// Medication
	void displayComboBox(ArrayList<String> hospDrugNames);
	
	void displayUpdateMedicationGrid(ArrayList<Medication> medication);

}
