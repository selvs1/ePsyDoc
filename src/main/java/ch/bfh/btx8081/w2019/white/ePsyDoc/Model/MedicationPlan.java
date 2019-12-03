package ch.bfh.btx8081.w2019.white.ePsyDoc.Model;

import java.util.ArrayList;

import net.bytebuddy.asm.Advice.Exit;

public class MedicationPlan {

	private int patientcaseID;
	private int patientID;
	private ArrayList<Medication> medicationplan = new ArrayList<Medication>();

	public MedicationPlan(int patientcaseID, int patientID) {
		this.patientcaseID = patientcaseID;
		this.patientID = patientID;
	}

	public ArrayList<Medication> getMedicationplan() {
		return medicationplan;
	}

	public void addToMedicationplan(Medication medication) {
		for (Medication medicationentry : medicationplan) {
			if (medicationentry.getbrandName() == medication.getbrandName()) {
				System.out.println("Not possible medication already added");
			} else {
				medicationplan.add(medication);
			}
		}
	}

	public void removeFromMedicationplan(String brandname) {
		for (Medication medication : medicationplan) {
			if (medication.getbrandName() == brandname) {
				medicationplan.remove(medication);
			} else {
				System.out.println("No such objekt found");
			}
		}
	}



}
