package ch.bfh.btx8081.w2019.white.ePsyDoc.Model;

import java.util.ArrayList;

import net.bytebuddy.asm.Advice.Exit;

public class MedicationPlan {

	private ArrayList<Medication> medicationPlan;

	public MedicationPlan() {
		this.medicationPlan = new ArrayList<Medication>();
	}

	public ArrayList<Medication> getMedicationPlan() {
		return medicationPlan;
	}

	public void addToMedicationPlan(Medication medication) {
		for (Medication medicationentry : medicationPlan) {
			if (medicationentry.getbrandName() == medication.getbrandName()) {
				System.out.println("Not possible medication already added");
			} else {
				medicationPlan.add(medication);
			}
		}
	}

	public void removeFromMedicationPlan(String brandname) {
		for (Medication medication : medicationPlan) {
			if (medication.getbrandName() == brandname) {
				medicationPlan.remove(medication);
			} else {
				System.out.println("No such objekt found");
			}
		}
	}

}
