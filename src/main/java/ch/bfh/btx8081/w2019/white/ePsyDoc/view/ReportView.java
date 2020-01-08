package ch.bfh.btx8081.w2019.white.ePsyDoc.view;

import java.util.List;

import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Diagnosis;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Doctor;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Medication;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.PatientCase;

/**
 * ReportView interface contains all functions which are adopted in the
 * ReportViewImpl class. The Interface ReportViewListener contains all functions
 * which are adopted in the ReportModel class.
 * 
 * @author Alain Nippel
 * @author Apiwat-David Gaupp
 * @author Janahan Sellathurai
 * @author Marko Miletic
 * @author Sugeelan Selvasingham
 * @author Viktor Velkov
 * 
 * @version 1.0
 */
public interface ReportView {

	interface ReportViewListener {

		void getAll(int patientCaseID);

		void addPatientCase(PatientCase patientCase);

		void removePatientCase(int patientCaseID);

		void addDiagnosis(int patientCaseID, Diagnosis diagnosis);

		void removeDiagnosis(int patientcase, Diagnosis diagnosis);

		void addMedication(int patientCaseID, Medication medication);

		void removeMedication(int patientcase, Medication medication);

		void saveReport(int patientCaseID, String report);

		void getPatientCaseObject(int patientCaseID);

		void getDoctorObject(int doctorID);

		void getPatientCaseList(int patientCaseID);

		void getDiagnosisList(int patientCaseID);

		void getMedicationList(int patientCaseID);

		void getDoctor(int patientCaseID);

	}

	void addListener(ReportViewListener listener);

	void displayDoctor(PatientCase patientCase);

	void displayDiagnosisList(List<Diagnosis> diagnosis);

	void displayMedicationList(List<Medication> medication);

	void displayRegister(List<PatientCase> patientCase);

	void displayReport(String report);

	void setPatientCase(PatientCase patientCase);

	void setDoctor(Doctor doctor);

	void refresh();

	void redirect();

	void setSessionID(int patientCaseID);

}
