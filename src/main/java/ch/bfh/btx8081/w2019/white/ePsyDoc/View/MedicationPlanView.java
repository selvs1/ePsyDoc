package ch.bfh.btx8081.w2019.white.ePsyDoc.View;

import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.Medication;

public interface MedicationPlanView {
	
	interface MedicationPlanViewListener {
		void clickNewMedicationPlan(int patientcaseID, int patientID);
		void clickAddToMedicationPlan(Medication medication);
		void clickRemoveFromMedicationPlan(String brandname);
	}

	void addListener(MedicationPlanViewListener listener);
}
