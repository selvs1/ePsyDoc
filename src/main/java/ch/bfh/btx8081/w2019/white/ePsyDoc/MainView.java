package ch.bfh.btx8081.w2019.white.ePsyDoc;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.w2019.white.ePsyDoc.ModelTemp.LoginModel;
import ch.bfh.btx8081.w2019.white.ePsyDoc.PresenterTemp.LoginPresenter;
import ch.bfh.btx8081.w2019.white.ePsyDoc.ViewTemp.LoginViewImpl;

@Route("")
public class MainView extends VerticalLayout {
	private static final long serialVersionUID = 1L;

	public MainView() {
		LoginModel model = new LoginModel();
		model.init();
		LoginViewImpl view = new LoginViewImpl();
		new LoginPresenter(model, view);
		add(view);
	}
}
