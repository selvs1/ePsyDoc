package ch.bfh.btx8081.w2019.white.ePsyDoc;

import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.LoginModel;
import ch.bfh.btx8081.w2019.white.ePsyDoc.Presenter.LoginPresenter;
import ch.bfh.btx8081.w2019.white.ePsyDoc.View.LoginViewImpl;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class MainView extends VerticalLayout {

	public MainView() {
		LoginModel model = new LoginModel();
		model.init(); // Testdaten erstellen
		LoginViewImpl view = new LoginViewImpl();
		new LoginPresenter(model, view);

		add(view);
	}

}
