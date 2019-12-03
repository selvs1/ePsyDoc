package ch.bfh.btx8081.w2019.white.ePsyDoc.Presenter;

import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.MedicationPlanModel;
import ch.bfh.btx8081.w2019.white.ePsyDoc.View.MedicationPlanView;
import ch.bfh.btx8081.w2019.white.ePsyDoc.View.MedicationPlanView.MedicationPlanViewListener;

public class MedicationPlanPresenter implements MedicationPlanViewListener {
	private MedicationPlanModel model;
	private MedicationPlanView view;

	public MedicationPlanPresenter(MedicationPlanModel model, MedicationPlanView view) {
	        this.model = model;
	        this.view = view;
	        view.addListener(this);
	    }

}
