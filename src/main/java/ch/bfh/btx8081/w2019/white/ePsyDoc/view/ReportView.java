package ch.bfh.btx8081.w2019.white.ePsyDoc.view;

import java.util.List;

import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Diagnosis;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Doctor;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Medication;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Patient;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.PatientCase;

public interface ReportView {

	interface ReportViewListener {
		
		void getAll(int patientCaseID, int patientID);

		void addPatientCase(PatientCase patientCase);

		void removePatientCase(int patientCaseID);

		void addDiagnosis(int patientCaseID, Diagnosis diagnosis);

		void removeDiagnosis(int patientcase, Diagnosis diagnosis);

		void addMedication(int patientCaseID, Medication medication);

		void removeMedication(int patientcase,Medication medication);

		void saveReport(int patientCaseID, String report);

		void getPatientCase(int patientCaseID);
		
		void getPatientCaseObject(int patientCaseID);
		
		void getDoctorObject(int doctorID);

		void getPatientCaseList(int patientCaseID);

		void getDiagnosisList(int patientCaseID);

		void getMedicationList(int patientCaseID);

		void getDoctor(int patientCaseID);
		

	}

	void addListener(ReportViewListener listener);

	void displayDoctor(PatientCase patientCase);

	// updated ganze Patientcaseview
	void updateAll(List<PatientCase> patientCaseList, PatientCase patientCase, List<Diagnosis> diagnosis,
			List<Medication> medication);

	void displayDiagnosisList(List<Diagnosis> diagnosis);

	void displayMedicationList(List<Medication> medication);

	void displayRegister(List<PatientCase> patientCase);
	
	void setPatientCase(PatientCase patientCase);
	
	void setDoctor(Doctor doctor);
	
	void refresh();
	
	void redirect();
	


}
