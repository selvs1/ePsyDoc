package ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class MedicationPlan {

	@Id
	@GeneratedValue
	private int medicationPlanID;
//	private ArrayList<Medication> medicationPlan;

	@OneToOne(mappedBy = "medicationPlan")
	private PatientCase patientCase;
	@OneToMany(mappedBy = "medicationPlan")
	private List<Medication> medications;



	public MedicationPlan() {
		this.medications = new ArrayList<Medication>();
	}


	public int getMedicationPlanID() {
		return medicationPlanID;
	}

	public void setMedicationPlanID(int medicationPlanID) {
		this.medicationPlanID = medicationPlanID;
	}

	public PatientCase getPatientCase() {
		return patientCase;
	}

	public void setPatientCase(PatientCase patientCase) {
		this.patientCase = patientCase;
	}

	public List<Medication> getMedications() {
		return medications;
	}
//	private ArrayList<Medication> medicationPlan; todo: 10.12.2019 - sugi
//	todo: medicationPlan werde ich in medications unbenennen. Es sind 6 Variablen betroffen - lg sugi



//	public ArrayList<Medication> getMedicationPlan() {
//		return medicationPlan;
//	}

	//todo: ??? das ist nicht oop. Nicht kompliziert denken. Problem versuchen zu minimieren - lg sugi
//	public void addToMedicationPlan(Medication medication) {
//		medicationPlan.add(medication);
//	}




	public void removeFromMedicationPlan(String brandname) {
		for (Medication medication : medications) {
			if (medication.getbrandName().equals(brandname)) {
				medications.remove(medication);
			} else {
				System.out.println("No such objekt found");
				//todo: Exception handling - lg sugi
			}
		}
	}

	@Override
	public String toString() {
		String listString = medications.stream().map(Object::toString)
                .collect(Collectors.joining(", "));
		return "MedicationPlan [medicationPlan=" + listString + "]";
	}


	public void setMedications(List<Medication> medications) {
		this.medications = medications;
	}
}
