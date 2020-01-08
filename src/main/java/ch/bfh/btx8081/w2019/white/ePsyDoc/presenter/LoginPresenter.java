package ch.bfh.btx8081.w2019.white.ePsyDoc.presenter;

import ch.bfh.btx8081.w2019.white.ePsyDoc.model.LoginModel;
import ch.bfh.btx8081.w2019.white.ePsyDoc.view.LoginView;

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
 *          connects model and view.
 */
public class LoginPresenter implements LoginView.LoginViewListener {

	private LoginModel model;
	private LoginView view;

	/**
	 * 
	 * @param model
	 * @param view
	 */
	public LoginPresenter(LoginModel model, LoginView view) {
		this.model = model;
		this.view = view;
		view.addListener(this);
	}

	/**
	 * @param username
	 * @param password
	 */
	@Override
	public void onLoginBtnClicked(String username, String password) {
		try {
			model.login(username, password);
			view.openSession();
		} catch (Exception e) {
			view.notifyProblem(e.getMessage());
		}

	}
}