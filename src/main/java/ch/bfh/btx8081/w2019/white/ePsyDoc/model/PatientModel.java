package ch.bfh.btx8081.w2019.white.ePsyDoc.model;

import java.util.ArrayList;
import java.util.List;

import ch.bfh.btx8081.w2019.white.ePsyDoc.database.Service;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Patient;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.PatientCase;

public class PatientModel {
	private List<Patient> patientList = new ArrayList<Patient>();
	private List<PatientCase> patientCaseList = new ArrayList<PatientCase>();

	private Service<Patient> patientService = new Service<>(new Patient());
	private Service<PatientCase> patientCaseService = new Service<>(new PatientCase());

	public PatientModel() {

	}

	public List<Patient> getPatientList() {
		return patientList;
	}

	public void setPatientList(List<Patient> patientList) {
		this.patientList = patientList;
	}

	public List<PatientCase> getPatientCaseList() {
		return patientCaseList;
	}

	public void setPatientCaseList(int patientID) {
		this.patientCaseList = patientCaseService.findByAttributFullDESC("patient.patientID", patientID,
				"patientCaseID");
	}

	public void init() {
		setPatientList(patientService.getEntityTable());
	}
}