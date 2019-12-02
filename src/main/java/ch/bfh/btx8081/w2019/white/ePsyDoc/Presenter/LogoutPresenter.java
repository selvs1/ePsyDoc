package ch.bfh.btx8081.w2019.white.ePsyDoc.Presenter;

import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.LogoutModel;
import ch.bfh.btx8081.w2019.white.ePsyDoc.View.LogoutView;
import ch.bfh.btx8081.w2019.white.ePsyDoc.View.LogoutView.LogoutViewListener;

public class LogoutPresenter implements LogoutViewListener {
	private  LogoutModel model;
	private  LogoutView view;

	public  LogoutPresenter( LogoutModel model,  LogoutView view) {
	        this.model = model;
	        this.view = view;
	        view.addListener(this);
	    }

}
