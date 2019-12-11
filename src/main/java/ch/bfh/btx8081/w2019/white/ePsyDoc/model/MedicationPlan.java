package ch.bfh.btx8081.w2019.white.ePsyDoc.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class MedicationPlan {

	@Id
	@GeneratedValue
	private int medicationPlanID;

	@OneToOne(mappedBy = "medicationPlan")
	private PatientCase patientCase;
	@OneToMany(mappedBy = "medicationPlan")
	private final List<Medication> medications = new ArrayList<>();


//	private ArrayList<Medication> medicationPlan; todo: 10.12.2019 - sugi
//	todo: medicationPlan werde ich in medications unbenennen. Es sind 6 Variablen betroffen - lg sugi

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
