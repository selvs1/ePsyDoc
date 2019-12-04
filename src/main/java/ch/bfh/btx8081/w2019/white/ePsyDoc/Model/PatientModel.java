package ch.bfh.btx8081.w2019.white.ePsyDoc.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PatientModel {

	private List<Patient> patientList;

	public PatientModel() {
		patientList = new ArrayList<Patient>();
	}

	public List<Patient> getPatientList() {
		return patientList;
	}

	public void setPatientList(List<Patient> patientList) {
		this.patientList = patientList;
	}

	public Patient getPatient(int patientID) {
		Patient returnPatient = null;
		for (Patient patient : patientList) {
			if (patient.getPatientID() == patientID) {
				returnPatient = patient;
			}
		}
		return returnPatient;
	}
	
	public void init() {
		Patient p = new Patient(1, "Muster", "Max", "M", new Date(2019,4,9), "Musterstrasse 34", "3333");
		patientList.add(p);
		p.createPatientCase("1.1", 1);
		PatientCase pc = p.getPatientCase("1.1");
		
		MedicationPlan mp = new MedicationPlan();
		mp.addToMedicationPlan(new Medication("Ibuprofen 600mg", "IBUPROFEN AL akut 600mg Film-coated-tablet","","","","","600mg",
							"Film-coated-tablet","Pcs","Take with a glas of water","Pain"));
		pc.setMedicationplan(mp);
		HospIndex drugList = new HospIndex();
		
		
	
		
		
	}
}
