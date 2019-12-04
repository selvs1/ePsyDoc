package ch.bfh.btx8081.w2019.white.ePsyDoc.View;

import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.Doctor;
import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.HospIndex;
import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.Medication;
import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.PatientCase;
import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.PatientModel;

public interface ReportView {
	
	interface ReportViewListener {
		//All
		void save(int intervall);
		void clickSetFields(PatientCase patientcase);
		
		//Report 
		void clickNewReport(Doctor doctor, PatientModel patient);
		void clickNewPatientCase(int patientCaseID, int patientID);
		void clickDeletePatientCase();
		void deleteDiagnose(); 
		
		//Medication
		void clickSetMedicationPlan(int patientcaseID, int patientID);
		void clickDisableFields();
		void clickAutofill();
		void clickAddMedication(Medication medication);
		void clickRemoveFromMedicationPlan(String brandname);


	}

	void addListener(ReportViewListener listener);
	
	//Report
	void displayPatientCaseTabs(int patientCaseID);
	void displayDoctorName(int doctorID);
	void displayPatientName(int patientID);
	void displayPatientCaseID(int patientCaseID);
	
	//Medication
	void displayComboBox(HospIndex hospIndex);
	
}
