package ch.bfh.btx8081.w2019.white.ePsyDoc.Model;

import java.util.ArrayList;
import java.util.stream.Collectors;

import net.bytebuddy.asm.Advice.Exit;

public class MedicationPlan {

	private ArrayList<Medication> medicationPlan;

	public MedicationPlan() {
		medicationPlan = new ArrayList<Medication>();
	}

	public ArrayList<Medication> getMedicationPlan() {
		return medicationPlan;
	}

	public void addToMedicationPlan(Medication medication) {
		medicationPlan.add(medication);
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

	@Override
	public String toString() {
		String listString = medicationPlan.stream().map(Object::toString)
                .collect(Collectors.joining(", "));
		return "MedicationPlan [medicationPlan=" + listString + "]";
	}

}
