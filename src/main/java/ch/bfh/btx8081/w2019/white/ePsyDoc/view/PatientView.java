package ch.bfh.btx8081.w2019.white.ePsyDoc.view;

import java.util.List;

import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Doctor;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Patient;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.PatientCase;

/**
 * PatientView interface contains all functions which are adopted in the
 * PatientViewListener class. The Interface PatientViewListener contains all
 * functions which are adopted in the PatientModel class.
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
public interface PatientView {
	interface PatientViewListener {
		void loadPatientList();

		void loadPatientCaseList();

		void setPatientCaseList(int patientID);

		void getPatientObject(int patientID);

		void getDoctorObject(int doctorID);

		void addPatientCase(PatientCase patientCase, int patientID);
	}

	void addListener(PatientViewListener listener);

	void displayPatientList(List<Patient> patientList);

	void displayPatientCaseList(List<PatientCase> patientCaseList);

	void setDoctor(Doctor doctor);

	void setPatient(Patient patient);
}