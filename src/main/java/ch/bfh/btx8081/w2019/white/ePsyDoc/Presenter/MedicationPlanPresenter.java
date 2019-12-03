package ch.bfh.btx8081.w2019.white.ePsyDoc.Presenter;

import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.Medication;
import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.MedicationPlan;
import ch.bfh.btx8081.w2019.white.ePsyDoc.View.MedicationPlanView;
import ch.bfh.btx8081.w2019.white.ePsyDoc.View.MedicationPlanView.MedicationPlanViewListener;

public class MedicationPlanPresenter implements MedicationPlanViewListener {
	private MedicationPlan model;
	private MedicationPlanView view;

	public MedicationPlanPresenter(MedicationPlan model, MedicationPlanView view) {
	        this.model = model;
	        this.view = view;
	        view.addListener(this);
	    }

	@Override
	public void clickNewMedicationPlan(int patientcaseID, int patientID) {
		model = new MedicationPlan(patientcaseID, patientID);
		
	}

	@Override
	public void clickAddToMedicationPlan(Medication medication) {
		model.addToMedicationplan(medication);
		
	}

	@Override
	public void clickRemoveFromMedicationPlan(String brandname) {
		model.removeFromMedicationplan(brandname);
		
	}

}
