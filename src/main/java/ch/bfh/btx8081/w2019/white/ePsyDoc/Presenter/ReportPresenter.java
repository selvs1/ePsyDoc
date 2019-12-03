package ch.bfh.btx8081.w2019.white.ePsyDoc.Presenter;

import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.Doctor;
import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.PatientModel;
import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.Report;
import ch.bfh.btx8081.w2019.white.ePsyDoc.View.ReportView;

public class ReportPresenter implements ReportView.ReportViewListener {
	private Report model;
	private ReportView view;

	public ReportPresenter(Report model, ReportView view) {
	        this.model = model;
	        this.view = view;
	        view.addListener(this);
	    }

	@Override
	public void clickNewReport(Doctor doctor, PatientModel patient) {
		model = new Report(doctor, patient);
		
	}

}
