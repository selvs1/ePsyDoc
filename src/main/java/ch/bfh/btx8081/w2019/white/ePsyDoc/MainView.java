package ch.bfh.btx8081.w2019.white.ePsyDoc;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.w2019.white.ePsyDoc.model.LoginModel;
import ch.bfh.btx8081.w2019.white.ePsyDoc.presenter.LoginPresenter;
import ch.bfh.btx8081.w2019.white.ePsyDoc.view.LoginViewImpl;

/**
 * @author Alain Nippel
 * @author Apiwat-David Gaupp
 * @author Janahan Sellathurai
 * @author Marko Miletic
 * @author Sugeelan Selvasingham
 * @author Viktor Velkov
 * 
 * @version 1.0
 * 
 *          Main view of the application.
 *
 */

@Route("")
public class MainView extends VerticalLayout {

	/**
	 * Constructor of main view. Create new Login model and view. Create new
	 * presenter with model and view Add view to GUI
	 */
	public MainView() {
		LoginModel model = new LoginModel();
		LoginViewImpl view = new LoginViewImpl();
		new LoginPresenter(model, view);
		add(view);
	}
}
