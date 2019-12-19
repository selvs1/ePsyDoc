package ch.bfh.btx8081.w2019.white.ePsyDoc.view;

import java.util.ArrayList;
import java.util.List;

import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Diagnosis;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Medication;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.MedicationPlan;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.PatientCase;

public interface ReportView {

	interface ReportViewListener {
		// Report
		void clickNewPatientCase(int patientCaseID, int patientID);

		void clickDeletePatientCase();

		void deleteDiagnose(Diagnosis diagnosis);
		void clickAddDiagnose(Diagnosis diagnosis);

		// Medication
		void clickAddMedication(Medication medication);

		void clickRemoveFromMedicationPlan(String brandname);
		
		void getPatientData();
		void getDoctorData();
		void getPatientCaseID();
		void getDiagnosis();
		void getMedications();

	}

	void addListener(ReportViewListener listener);

	// Report
	void displayPatientCaseTabs(ArrayList<String> patientCaseIDs);

	void displayDoctorName(String firstname, String name);

	void displayPatientName(String firstname, String name);

	void displayPatientCaseID(String patientCaseID);



	// Medication
	void displayUpdateMedicationGrid(MedicationPlan medicationPlan);

	void displayUpdateDiagnosisGrid(List<Diagnosis> diagnosis);

	void displayPatientCase(PatientCase tempPatientCase);

	

}
