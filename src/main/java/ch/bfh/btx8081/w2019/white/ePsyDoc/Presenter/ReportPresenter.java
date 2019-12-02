package ch.bfh.btx8081.w2019.white.ePsyDoc.Presenter;

import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.ReportModel;
import ch.bfh.btx8081.w2019.white.ePsyDoc.View.ReportView;

public class ReportPresenter implements ReportView.ReportViewListener {
	private ReportModel model;
	private ReportView view;

	public ReportPresenter(ReportModel model, ReportView view) {
	        this.model = model;
	        this.view = view;
	        view.addListener(this);
	    }

}
