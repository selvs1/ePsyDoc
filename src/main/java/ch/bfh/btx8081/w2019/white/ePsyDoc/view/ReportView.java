package ch.bfh.btx8081.w2019.white.ePsyDoc.view;

import java.util.List;

import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Diagnosis;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Doctor;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Medication;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Patient;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.PatientCase;

public interface ReportView {

	interface ReportViewListener {
		void createPatientCase(Patient patient, Doctor doctor);

		void removePatientCase(int patientCaseID);

		void createDiagnosis(int patientCaseID,Diagnosis diagnosis);

		void removeDiagnosis(int diagnosisID);

		void createMedication(int patientCaseID,Medication medication);

		void removeMedication(int medicationID);

		void save(int patientCaseID, String consultation);

		void getPatientCase(int patientCaseID);
		void getPatientCaseList(int patientCaseID);

		void getDiagnosisList(int patientCaseID);

		void getMedicationList(int patientCaseID);
		
		void getDoctor(int patientCaseID);

		
	}

	void addListener(ReportViewListener listener);

	void displayDoctor(PatientCase patientCase);

	void updateAll(List<PatientCase> patientCaseList,PatientCase patientCase,List<Diagnosis> diagnosis,List<Medication> medication);

	void displayDiagnosisList(List<Diagnosis> diagnosis);

	void displayMedicationList(List<Medication> medication);

	void displayRegister(List<PatientCase> patientCase);

	void changeRegister();

}
